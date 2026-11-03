package io.jenkins.plugins.darktheme;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
class DarkThemeCssTest {

    @Test
    void overridesLegacyGreys(JenkinsRule j) throws Exception {
        String css = getThemeCss(j);

        // Core still uses these for pane headers, bigtables and striped rows,
        // its light values make text unreadable in the dark theme
        assertThat(css, containsString("--very-light-grey:"));
        assertThat(css, containsString("--light-grey:"));
        assertThat(css, containsString("--medium-grey:"));
    }

    @Test
    void doesNotReferenceRemovedVariables(JenkinsRule j) throws Exception {
        String css = getThemeCss(j);

        assertThat(css, not(containsString("var(--dark-theme-bg-")));
    }

    private static String getThemeCss(JenkinsRule j) throws Exception {
        try (JenkinsRule.WebClient wc = j.createWebClient()) {
            return wc.goTo(DarkThemeManagerFactory.THEME_URL_NAME + "/" + DarkThemeManagerFactory.THEME_CSS, "text/css")
                    .getWebResponse()
                    .getContentAsString();
        }
    }
}
