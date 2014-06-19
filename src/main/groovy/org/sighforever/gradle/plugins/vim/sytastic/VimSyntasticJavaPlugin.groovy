package org.sighforever.gradle.plugins.vim.syntastic

import org.gradle.api.Plugin
import org.gradle.api.Project

class VimSyntasticJavaPlugin implements Plugin<Project> {
  void apply(Project project) {
    project.extensions.create("vimSyntasticJava", SyntasticData)

    def classPathCollection = new HashSet<String>()

    def addPath = { proj ->
      if (proj.plugins.hasPlugin("java")) {
        proj.configurations.compile.each { jar ->
            classPathCollection.add(jar);
          }
        }

      proj.sourceSets.each { srcSet ->
        srcSet.java.srcDirs.each { dir ->
          classPathCollection.add(dir.absolutePath)
        }
      }
    }

    project.task("vimSyntasticJava") << {
      project.allprojects.each { proj -> 
        addPath(proj) 
      }

      new File(project.projectDir.absolutePath + "/" + "${project.syntastic.classpathFile}").text = classPathCollection.collect().join("\n")
    }
  }
} 

class SyntasticData {
  def String classpathFile = ".syntastic-classpath"
}
