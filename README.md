# Cameek Spring Sandbox


**org.cameek.spring\_sandbox** is a minimal Kotlin + Spring Boot 3 playground that demonstrates how to consume the Bitfinex public REST API and expose the data through a reactive WebFlux endpoint. Use it as a starting point for experimenting with Spring Boot 3, WebFlux, Kotlin, and Gradle.

---

## ✨ Features

- **Reactive WebFlux REST API**: `GET /bitfinex/last-month-data` streams the last 30 daily candles (1‑day timeframe) for *BTC/USD*.
- **Non‑blocking **`` to call Bitfinex’s public Candles endpoint.
- Simple `` (timestamp, open, close, high, low, volume) for fast JSON mapping via Jackson‑Kotlin.
- Gradle Wrapper (8.13) with Kotlin DSL — zero global toolchain setup.
- Works out‑of‑the‑box on **JDK 17–21**.

---

## 📦 Prerequisites & Installation

1. **JDK 17+** (tested with Temurin 21).
2. Git.

```bash
# clone the repo
git clone https://github.com/your‑org/org.cameek.spring_sandbox.git
cd org.cameek.spring_sandbox

# run the app
./gradlew bootRun   # use gradlew.bat on Windows
```

Gradle will download all dependencies automatically.

---

## 🛠 Usage

Once the app is running (default port **8080**):

```text
GET http://localhost:8080/bitfinex/last-month-data
```

Example with `curl`:

```bash
curl http://localhost:8080/bitfinex/last-month-data | jq
```

```json
[
  {
    "timestamp": 1712188800000,
    "open": 70345.0,
    "close": 70812.0,
    "high": 71200.0,
    "low": 68200.0,
    "volume": 1234.5678
  }
  // …29 more candle objects
]
```

---

## 🔧 Project Structure

```
src
 └─ main
    ├─ kotlin/org/cameek/spring_sandbox
    │   ├─ Application.kt            # Spring Boot entry
    │   └─ bitfinex
    │       ├─ CandleData.kt         # data class
    │       ├─ BitfinexService.kt    # calls Bitfinex API
    │       └─ BitfinexController.kt # exposes REST endpoint
    └─ resources
        └─ application.properties
```

---

## 🚀 Building a Jar

```bash
./gradlew bootJar
java -jar build/libs/org.cameek.spring_sandbox-0.0.1-SNAPSHOT.jar
```

---

## 🧪 Running Tests

```bash
./gradlew test
```

---

## 📄 License

Licensed under the **MIT License**.\
See the [LICENSE](LICENSE) file for full details.

---

## 👤 Author

Created and maintained by [**CameekOrg**](https://github.com/cameekorg).

---

## 📬 Related Projects & Resources

- [Spring Boot](https://spring.io/projects/spring-boot) – Production‑ready Spring framework
- [Kotlin](https://kotlinlang.org/) – Modern JVM language
- [Bitfinex API Docs](https://docs.bitfinex.com/docs) – REST and WebSocket APIs
- [Gradle](https://gradle.org/) – Build automation

*org.cameek.spring\_sandbox is not affiliated with Bitfinex. Use the exchange data at your own risk.*

