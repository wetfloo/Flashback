import buildlogic.configureAndroidCompose
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidComposeLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("buildlogic.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }
        }
    }
}
