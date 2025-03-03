package io.jenkins.plugins.darktheme.jcasc.darksystem;

import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.darktheme.DarkThemeSystemManagerFactory;
import io.jenkins.plugins.darktheme.jcasc.AbstractThemeJCasCTest;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

@WithJenkinsConfiguredWithCode
class DarkSystemThemeJCasCTest extends AbstractThemeJCasCTest {

    @Override
    protected Class<? extends ThemeManagerFactory> getThemeManagerFactory() {
        return DarkThemeSystemManagerFactory.class;
    }
}
