object Deps {
    object Kotlinx {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$1.5.1-native-mt"
        const val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.2"
    }

    object Koin {
        private const val version = "3.1.2"
        const val core = "io.insert-koin:koin-core:$version"
        const val test = "io.insert-koin:koin-test:$version"
        const val testJUnit4 = "io.insert-koin:koin-test-junit4:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
    }

    object Ktor {
        private const val version = "1.6.3"
        const val serverCore = "io.ktor:ktor-server-core:$version"
        const val serverNetty = "io.ktor:ktor-server-netty:$version"
        const val serialization = "io.ktor:ktor-serialization:$version"
        const val websockets = "io.ktor:ktor-websockets:$version"
        const val clientCore = "io.ktor:ktor-client-core:$version"
        const val clientJson = "io.ktor:ktor-client-json:$version"
        const val clientLogging = "io.ktor:ktor-client-logging:$version"
        const val clientSerialization = "io.ktor:ktor-client-serialization:$version"
        const val clientAndroid = "io.ktor:ktor-client-android:$version"
        const val clientApache = "io.ktor:ktor-client-apache:$version"
        const val clientJava = "io.ktor:ktor-client-java:$version"
        const val clientIos = "io.ktor:ktor-client-ios:$version"
        const val clientCio = "io.ktor:ktor-client-cio:$version"
        const val clientCurl = "io.ktor:ktor-client-curl:$version"
        const val clientJs = "io.ktor:ktor-client-js:$version"
    }
}