//rootProject.name = "dep"
//include("lib")

sourceControl {
    gitRepository(java.net.URI.create("https://github.com/jectivex/CrossFile.git")) {
        producesModule("CrossFile:CrossFile")
    }
}


