package io.jenkins.plugins.darktheme;

import static io.jenkins.plugins.darktheme.DarkThemeManagerFactory.*;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class DarkThemeSystemManagerFactory extends ThemeManagerFactory {

    @DataBoundConstructor
    public DarkThemeSystemManagerFactory() {}

    @Override
    public Theme getTheme() {
        return Theme.builder()
                .respectSystemAppearance()
                .withProperty("ace-editor", "theme-dark", ACE_EDITOR_THEME)
                .withProperty("entra-id", "theme-dark", ENTRA_ID_THEME)
                .withProperty("bootstrap", "theme-dark", BOOTSTRAP_THEME)
                .build();
    }

    @Extension
    @Symbol("darkSystem")
    public static class DarkThemeSystemManagerFactoryDescriptor extends ThemeManagerFactoryDescriptor {

        @NonNull
        @Override
        public String getDisplayName() {
            return "Dark (System)";
        }

        @Override
        public String getIconClassName() {
            return "symbol-moon-outline plugin-ionicons-api";
        }

        @NonNull
        @Override
        public String getThemeId() {
            return "dark";
        }

        @Override
        public String getThemeKey() {
            return "dark-system";
        }

        @Override
        public boolean isNamespaced() {
            return true;
        }
    }
}
