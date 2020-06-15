package io.jenkins.plugins.darktheme;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class DarkThemeManagerFactory extends ThemeManagerFactory {

    public static final String THEME_CSS = "theme.css";
    public static final String THEME_URL_NAME = "theme-dark";

    @DataBoundConstructor
    public DarkThemeManagerFactory() {
    }

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .withCssUrl(getCssUrl())
                .build();
    }
    
    @Extension
    @Symbol("dark")
    public static class DarkThemeManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "Dark";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new DarkThemeManagerFactory();
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "dark";
        }
    }
}
