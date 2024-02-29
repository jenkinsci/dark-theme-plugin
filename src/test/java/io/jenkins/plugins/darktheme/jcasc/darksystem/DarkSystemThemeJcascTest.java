package io.jenkins.plugins.darktheme.jcasc.darksystem;

import static io.jenkins.plugins.casc.misc.Util.toStringFromYamlFile;
import static io.jenkins.plugins.casc.misc.Util.toYamlString;
import static io.jenkins.plugins.darktheme.jcasc.dark.DarkThemeJcascTest.getAppearanceRoot;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

import io.jenkins.plugins.casc.ConfigurationContext;
import io.jenkins.plugins.casc.ConfiguratorRegistry;
import io.jenkins.plugins.casc.misc.ConfiguredWithCode;
import io.jenkins.plugins.casc.misc.JenkinsConfiguredWithCodeRule;
import io.jenkins.plugins.casc.model.CNode;
import io.jenkins.plugins.darktheme.DarkThemeSystemManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerPageDecorator;
import org.junit.ClassRule;
import org.junit.Test;

public class DarkSystemThemeJcascTest {

    @ClassRule
    @ConfiguredWithCode("ConfigurationAsCode.yml")
    public static JenkinsConfiguredWithCodeRule j = new JenkinsConfiguredWithCodeRule();

    @Test
    public void testConfig() {
        ThemeManagerPageDecorator decorator = ThemeManagerPageDecorator.get();

        ThemeManagerFactory theme = decorator.getTheme();
        assertNotNull(theme);

        assertThat(decorator.isDisableUserThemes(), is(true));
        assertThat(theme, instanceOf(DarkThemeSystemManagerFactory.class));
    }

    @Test
    public void testExport() throws Exception {
        ConfigurationContext context = new ConfigurationContext(ConfiguratorRegistry.get());
        CNode yourAttribute = getAppearanceRoot(context).get("themeManager");

        String exported = toYamlString(yourAttribute);

        String expected = toStringFromYamlFile(this, "ConfigurationAsCodeExport.yml");

        assertThat(exported, is(expected));
    }
}
