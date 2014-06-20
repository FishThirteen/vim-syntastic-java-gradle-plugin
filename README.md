vim-syntastic-java-gradle-plugin
================================

A gradle plugin to generate vim syntastic file in order to make the vim syntastic plugin found the project dependencies.


Build
--------------------------------
run `gradle build` and produce the `vim-syntastic-java-gradle-plugin-version.jar` in the `buidl/libs` directory.


How to use
--------------------------------
configure your project

    cd your-project-directoory
    mkdir libs
    copy vim-syntastic-java-gradle-plugin-version.jar to libs


add following code to your project's `build.gradle` file

    buildscript {
        dependencies {
            classpath files("libs/vim-syntastic-java-gradle-plugin-version.jar")
        }
    }
    
    apply plugin: 'vimsyntasticjava'


Run `gradle vimSyntasticJava` in your project, the `.syntastic-classpath` will be created in the proejct root directory.

copy the all content in `vim/vimrc_addon` to your .vimrc file, the vim will recursively find the `.syntastic-classpath` file.




    


