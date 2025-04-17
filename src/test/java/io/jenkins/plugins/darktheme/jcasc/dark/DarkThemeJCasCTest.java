package io.jenkins.plugins.darktheme.jcasc.dark;

import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.darktheme.DarkThemeManagerFactory;
import io.jenkins.plugins.darktheme.jcasc.AbstractThemeJCasCTest;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

@WithJenkinsConfiguredWithCode
class DarkThemeJCasCTest extends AbstractThemeJCasCTest {

    @Override
    protected Class<? extends ThemeManagerFactory> getThemeManagerFactory() {
        return DarkThemeManagerFactory.class;
    }
}
