package io.jenkins.plugins.darktheme.jcasc;

import static io.jenkins.plugins.casc.misc.Util.toStringFromYamlFile;
import static io.jenkins.plugins.casc.misc.Util.toYamlString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import hudson.ExtensionList;
import io.jenkins.plugins.casc.ConfigurationContext;
import io.jenkins.plugins.casc.ConfiguratorRegistry;
import io.jenkins.plugins.casc.impl.configurators.GlobalConfigurationCategoryConfigurator;
import io.jenkins.plugins.casc.misc.ConfiguredWithCode;
import io.jenkins.plugins.casc.misc.JenkinsConfiguredWithCodeRule;
import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.casc.model.CNode;
import io.jenkins.plugins.casc.model.Mapping;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerPageDecorator;
import java.util.Objects;
import jenkins.appearance.AppearanceCategory;
import jenkins.model.GlobalConfigurationCategory;
import org.junit.jupiter.api.Test;

@WithJenkinsConfiguredWithCode
public abstract class AbstractThemeJCasCTest {

    protected abstract Class<? extends ThemeManagerFactory> getThemeManagerFactory();

    @Test
    @ConfiguredWithCode("ConfigurationAsCode.yml")
    void testConfig(JenkinsConfiguredWithCodeRule j) {
        ThemeManagerPageDecorator decorator = ThemeManagerPageDecorator.get();

        ThemeManagerFactory theme = decorator.getTheme();
        assertNotNull(theme);

        assertThat(decorator.isDisableUserThemes(), is(true));
        assertThat(theme, instanceOf(getThemeManagerFactory()));
    }

    @Test
    @ConfiguredWithCode("ConfigurationAsCode.yml")
    void testExport(JenkinsConfiguredWithCodeRule j) throws Exception {
        ConfigurationContext context = new ConfigurationContext(ConfiguratorRegistry.get());
        CNode yourAttribute = getAppearanceRoot(context).get("themeManager");

        String exported = toYamlString(yourAttribute);

        String expected = toStringFromYamlFile(this, "ConfigurationAsCodeExport.yml");

        assertThat(exported, is(expected));
    }

    protected static Mapping getAppearanceRoot(ConfigurationContext context) {
        GlobalConfigurationCategory category =
                ExtensionList.lookup(AppearanceCategory.class).get(0);
        GlobalConfigurationCategoryConfigurator configurator = new GlobalConfigurationCategoryConfigurator(category);
        return Objects.requireNonNull(configurator.describe(configurator.getTargetComponent(context), context))
                .asMapping();
    }
}
