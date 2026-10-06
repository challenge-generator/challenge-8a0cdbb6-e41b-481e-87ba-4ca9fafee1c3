# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/bankaccount/application/AccountServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/bankaccount/Application.java` — `com.bankaccount.application.config.AccountProperties`: El import com.bankaccount.application.config.AccountProperties usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/bankaccount/domain/model/Account.java` — `Account.getStatus`: Se invoca `getStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/domain/model/Account.java` — `Account.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/application/AccountService.java` — `Account.setStatus`: Se invoca `setStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/application/AccountService.java` — `Account.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/application/AccountService.java` — `AccountRepository.existsById`: Se invoca `existsById` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/adapters/AccountRepositoryAdapter.java` — `Account.getId`: Se invoca `getId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/adapters/AccountRepositoryAdapter.java` — `Account.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.createAccount`: Se invoca `createAccount` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.accountNumber`: Se invoca `accountNumber` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.accountHolder`: Se invoca `accountHolder` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.accountType`: Se invoca `accountType` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.initialBalance`: Se invoca `initialBalance` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findById`: Se invoca `findById` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findByAccountNumber`: Se invoca `findByAccountNumber` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findByAccountHolder`: Se invoca `findByAccountHolder` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findByStatus`: Se invoca `findByStatus` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.amount`: Se invoca `amount` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.targetAccountNumber`: Se invoca `targetAccountNumber` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.applyInterest`: Se invoca `applyInterest` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.updateStatus`: Se invoca `updateStatus` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.status`: Se invoca `status` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.getTotalBalanceByAccountHolder`: Se invoca `getTotalBalanceByAccountHolder` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getId`: Se invoca `getId` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getAccountNumber`: Se invoca `getAccountNumber` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getAccountHolder`: Se invoca `getAccountHolder` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getBalance`: Se invoca `getBalance` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getInterestRate`: Se invoca `getInterestRate` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getOverdraftLimit`: Se invoca `getOverdraftLimit` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.transfer`: Se invoca `transfer` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.getAccountHolder`: Se invoca `getAccountHolder` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.getBalance`: Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.isPresent`: Se invoca `isPresent` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.get`: Se invoca `get` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `AccountService.applyInterest`: Se invoca `applyInterest` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Aplica los principios básicos de la programación orientada a objetos en el código (también conocida como OOP). Esto incluye los pilares de OOP, bucles, genéricos, anotaciones y más.

### Misión / candidato
Candidato con experiencia en Backend Java, trabajando en proyectos con enfoque en arquitectura orientada a objetos.

### Reto
- Tema: Desarrollo de Software con OOP
- Seniority: advanced-l1
- Tipo: practical
- Título: Aplicación de OOP en un Sistema de Gestión de Cuentas Bancarias
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Modelado de Cuentas Bancarias — objetivo: Definir y modelar las diferentes clases de cuentas bancarias utilizando principios de OOP. — entregable (NO resolver): Diagrama de clases y descripción de las relaciones de herencia y polimorfismo.
- Fase 2: Implementación de Operaciones — objetivo: Implementar operaciones básicas (depósito, retiro, transferencia) en las clases de cuentas. — entregable (NO resolver): Código implementado para las operaciones de depósito, retiro y transferencia en las clases de cuentas.
- Fase 3: Pruebas y Refactorización — objetivo: Realizar pruebas unitarias y refactorizar el código para mejorar su calidad y mantenibilidad. — entregable (NO resolver): Código refactorizado y pruebas unitarias implementadas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.bankaccount</groupId>
    <artifactId>bank-account-system</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>bank-account-system</name>
    <description>Sistema de gestión de cuentas bancarias con OOP</description>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/bankaccount/Application.java ===
package com.bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.bankaccount.application.config.AccountProperties;

@SpringBootApplication
@ComponentScan(basePackages = "com.bankaccount")
@EnableJpaRepositories(basePackages = "com.bankaccount.infrastructure.adapters")
@EnableTransactionManagement
@EnableConfigurationProperties(AccountProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> loggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);

        FilterRegistrationBean<CommonsRequestLoggingFilter> registration = new FilterRegistrationBean<>(filter);
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public String dummyDataInitializer() {
        return "Initialized";
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: bank-account-system
  datasource:
    url: jdbc:h2:mem:bankaccountdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driver-class-name: org.h2.Driver
    username: sa
    password: ""
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: true

server:
  port: 8080
  servlet:
    context-path: /api

logging:
  level:
    org.springframework.web: DEBUG
    com.bankaccount: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

account:
  min-deposit-amount: 1.0
  max-withdrawal-daily-limit: 1000.0

// === ARCHIVO: src/main/java/com/bankaccount/domain/model/Account.java ===
package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Account {
    @NotNull
    private UUID id;

    @NotNull
    @Size(min = 5, max = 50)
    private String accountNumber;

    @NotNull
    @Size(min = 3, max = 100)
    private String accountHolder;

    @NotNull
    @Positive
    private BigDecimal balance;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

    @NotNull
    private AccountStatus status;

    public enum AccountStatus {
        ACTIVE, BLOCKED, CLOSED
    }

    public abstract void deposit(@NotNull @Positive BigDecimal amount);

    public abstract void withdraw(@NotNull @Positive BigDecimal amount);

    public void transfer(@NotNull Account targetAccount, @NotNull @Positive BigDecimal amount) {
        if (this.status != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot transfer from a non-active account");
        }
        if (targetAccount.getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException("Cannot transfer to a non-active account");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds for transfer");
        }

        this.withdraw(amount);
        targetAccount.deposit(amount);
        this.updatedAt = LocalDateTime.now();
        targetAccount.setUpdatedAt(LocalDateTime.now());
    }

    protected void validatePositiveAmount(@NotNull @Positive BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public static class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/com/bankaccount/domain/model/SavingsAccount.java ===
package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
    @NotNull
    @Positive
    private BigDecimal interestRate;

    public SavingsAccount() {
        super();
        this.interestRate = BigDecimal.ZERO;
    }

    public SavingsAccount(UUID id, String accountNumber, String accountHolder, BigDecimal balance,
                         LocalDateTime createdAt, LocalDateTime updatedAt, AccountStatus status,
                         BigDecimal interestRate) {
        super(id, accountNumber, accountHolder, balance, createdAt, updatedAt, status);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        setBalance(getBalance().add(amount));
        setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public void withdraw(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        if (getBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        setBalance(getBalance().subtract(amount));
        setUpdatedAt(LocalDateTime.now());
    }

    public void applyInterest() {
        BigDecimal interest = getBalance().multiply(interestRate).divide(BigDecimal.valueOf(100));
        deposit(interest);
    }
}

// === ARCHIVO: src/main/java/com/bankaccount/domain/model/CurrentAccount.java ===
package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentAccount extends Account {
    @NotNull
    @Positive
    private BigDecimal overdraftLimit;

    public CurrentAccount() {
        super();
        this.overdraftLimit = BigDecimal.ZERO;
    }

    public CurrentAccount(UUID id, String accountNumber, String accountHolder, BigDecimal balance,
                         LocalDateTime createdAt, LocalDateTime updatedAt, AccountStatus status,
                         BigDecimal overdraftLimit) {
        super(id, accountNumber, accountHolder, balance, createdAt, updatedAt, status);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        setBalance(getBalance().add(amount));
        setUpdatedAt(LocalDateTime.now());
    }

    @Override
    public void withdraw(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        BigDecimal availableBalance = getBalance().add(overdraftLimit);
        if (availableBalance.compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds including overdraft limit");
        }
        setBalance(getBalance().subtract(amount));
        setUpdatedAt(LocalDateTime.now());
    }
}

// === ARCHIVO: src/main/java/com/bankaccount/domain/model/InvestmentAccount.java ===
package com.bankaccount.domain.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;

public class InvestmentAccount extends Account {
    
    private BigDecimal interestRate;
    private BigDecimal minimumBalance;
    private InvestmentRiskLevel riskLevel;
    private LocalDateTime lastInterestCalculation;
    private boolean compoundInterest;
    
    public enum InvestmentRiskLevel {
        LOW, MEDIUM, HIGH
    }
    
    public InvestmentAccount() {
        super();
        this.riskLevel = InvestmentRiskLevel.LOW;
        this.compoundInterest = true;
        this.lastInterestCalculation = LocalDateTime.now();
    }
    
    public InvestmentAccount(UUID id, String accountNumber, String accountHolder, 
                             BigDecimal balance, BigDecimal interestRate, 
                             BigDecimal minimumBalance, InvestmentRiskLevel riskLevel) {
        super(id, accountNumber, accountHolder, balance, LocalDateTime.now(), 
              LocalDateTime.now(), AccountStatus.ACTIVE);
        this.interestRate = interestRate != null ? interestRate : new BigDecimal("0.045");
        this.minimumBalance = minimumBalance != null ? minimumBalance : new BigDecimal("1000.00");
        this.riskLevel = riskLevel != null ? riskLevel : InvestmentRiskLevel.LOW;
        this.compoundInterest = true;
        this.lastInterestCalculation = LocalDateTime.now();
    }
    
    @Override
    public void deposit(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        validateAccountIsActive();
        
        BigDecimal newBalance = getBalance().add(amount);
        setBalance(newBalance);
        setUpdatedAt(LocalDateTime.now());
        
        if (newBalance.compareTo(minimumBalance) >= 0 && !compoundInterest) {
            applyInterest();
        }
    }
    
    @Override
    public void withdraw(@NotNull @Positive BigDecimal amount) {
        validatePositiveAmount(amount);
        validateAccountIsActive();
        
        BigDecimal availableBalance = calculateAvailableBalance();
        if (availableBalance.compareTo(amount) < 0) {
            throw new InsufficientFundsException(
                "Fondos insuficientes para retiro. Disponible: " + availableBalance + 
                ", solicitado: " + amount
            );
        }
        
        BigDecimal newBalance = getBalance().subtract(amount);
        setBalance(newBalance);
        setUpdatedAt(LocalDateTime.now());
        
        if (newBalance.compareTo(minimumBalance) < 0) {
            applyPenalty();
        }
    }
    
    public void applyInterest() {
        if (getStatus() != AccountStatus.ACTIVE) {
            return;
        }
        
        BigDecimal currentBalance = getBalance();
        BigDecimal interest = currentBalance.multiply(interestRate)
            .divide(new BigDecimal("12"), RoundingMode.HALF_UP);
        
        BigDecimal newBalance = currentBalance.add(interest);
        setBalance(newBalance);
        setUpdatedAt(LocalDateTime.now());
        lastInterestCalculation = LocalDateTime.now();
    }
    
    public void applyCompoundInterest(int months) {
        if (!compoundInterest || getStatus() != AccountStatus.ACTIVE) {
            return;
        }
        
        BigDecimal currentBalance = getBalance();
        BigDecimal monthlyRate = interestRate.divide(new BigDecimal("12"), 
            RoundingMode.HALF_UP);
        
        BigDecimal compoundFactor = new BigDecimal("1").add(monthlyRate);
        BigDecimal compoundedBalance = currentBalance;
        
        for (int i = 0; i < months; i++) {
            compoundedBalance = compoundedBalance.multiply(compoundFactor);
        }
        
        BigDecimal interestEarned = compoundedBalance.subtract(currentBalance);
        setBalance(compoundedBalance.setScale(2, RoundingMode.HALF_UP));
        setUpdatedAt(LocalDateTime.now());
        lastInterestCalculation = LocalDateTime.now();
    }
    
    private void applyPenalty() {
        BigDecimal penalty = new BigDecimal("25.00");
        setBalance(getBalance().subtract(penalty));
    }
    
    private BigDecimal calculateAvailableBalance() {
        BigDecimal balance = getBalance();
        if (balance.compareTo(minimumBalance) < 0) {
            return BigDecimal.ZERO;
        }
        return balance.subtract(minimumBalance);
    }
    
    private void validateAccountIsActive() {
        if (getStatus() != AccountStatus.ACTIVE) {
            throw new IllegalStateException(
                "La cuenta de inversión no está activa. Estado actual: " + getStatus()
            );
        }
    }
    
    public BigDecimal getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
    
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
    
    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
    
    public InvestmentRiskLevel getRiskLevel() {
        return riskLevel;
    }
    
    public void setRiskLevel(InvestmentRiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }
    
    public LocalDateTime getLastInterestCalculation() {
        return lastInterestCalculation;
    }
    
    public void setLastInterestCalculation(LocalDateTime lastInterestCalculation) {
        this.lastInterestCalculation = lastInterestCalculation;
    }
    
    public boolean isCompoundInterest() {
        return compoundInterest;
    }
    
    public void setCompoundInterest(boolean compoundInterest) {
        this.compoundInterest = compoundInterest;
    }
}

// === ARCHIVO: src/main/java/com/bankaccount/domain/ports/AccountRepository.java ===
package com.bankaccount.domain.ports;

import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.Account.AccountStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    
    Account save(Account account);
    
    Optional<Account> findById(UUID id);
    
    Optional<Account> findByAccountNumber(String accountNumber);
    
    List<Account> findAll();
    
    List<Account> findByStatus(AccountStatus status);
    
    List<Account> findByAccountHolder(String accountHolder);
    
    void deleteById(UUID id);
    
    boolean existsByAccountNumber(String accountNumber);
    
    long count();
    
    List<Account> findByAccountHolderContainingIgnoreCase(String partialName);
}

// === ARCHIVO: src/main/java/com/bankaccount/application/AccountService.java ===
package com.bankaccount.application;


import com.bankaccount.domain.model.InvestmentRiskLevel;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.Account.AccountStatus;
import com.bankaccount.domain.model.Account.InsufficientFundsException;
import com.bankaccount.domain.model.CurrentAccount;
import com.bankaccount.domain.model.InvestmentAccount;
import com.bankaccount.domain.model.SavingsAccount;
import com.bankaccount.domain.ports.AccountRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AccountService {
    
    private final AccountRepository accountRepository;
    
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public Account createSavingsAccount(
            @NotNull UUID id,
            @NotBlank String accountNumber,
            @NotBlank String accountHolder,
            @NotNull @Valid BigDecimal initialBalance,
            BigDecimal interestRate) {
        
        validateAccountNumberNotExists(accountNumber);
        validateInitialBalance(initialBalance);
        
        SavingsAccount account = new SavingsAccount(
            id, accountNumber, accountHolder, initialBalance, interestRate
        );
        return accountRepository.save(account);
    }
    
    public Account createCurrentAccount(
            @NotNull UUID id,
            @NotBlank String accountNumber,
            @NotBlank String accountHolder,
            @NotNull @Valid BigDecimal initialBalance,
            BigDecimal overdraftLimit) {
        
        validateAccountNumberNotExists(accountNumber);
        validateInitialBalance(initialBalance);
        
        CurrentAccount account = new CurrentAccount(
            id, accountNumber, accountHolder, initialBalance, overdraftLimit
        );
        return accountRepository.save(account);
    }
    
    public Account createInvestmentAccount(
            @NotNull UUID id,
            @NotBlank String accountNumber,
            @NotBlank String accountHolder,
            @NotNull @Valid BigDecimal initialBalance,
            BigDecimal interestRate,
            BigDecimal minimumBalance,
            InvestmentAccount.InvestmentRiskLevel riskLevel) {
        
        validateAccountNumberNotExists(accountNumber);
        validateInitialBalance(initialBalance);
        
        InvestmentAccount account = new InvestmentAccount(
            id, accountNumber, accountHolder, initialBalance,
            interestRate, minimumBalance, riskLevel
        );
        return accountRepository.save(account);
    }
    
    public void deposit(@NotNull UUID accountId, @NotNull @Valid BigDecimal amount) {
        Account account = findAccountById(accountId);
        account.deposit(amount);
        accountRepository.save(account);
    }
    
    public void withdraw(@NotNull UUID accountId, @NotNull @Valid BigDecimal amount) {
        Account account = findAccountById(accountId);
        account.withdraw(amount);
        accountRepository.save(account);
    }
    
    public void transfer(
            @NotNull UUID sourceAccountId,
            @NotNull UUID targetAccountId,
            @NotNull @Valid BigDecimal amount) {
        
        if (sourceAccountId.equals(targetAccountId)) {
            throw new IllegalArgumentException(
                "No se puede transferir a la misma cuenta origen y destino"
            );
        }
        
        Account sourceAccount = findAccountById(sourceAccountId);
        Account targetAccount = findAccountById(targetAccountId);
        
        sourceAccount.transfer(targetAccount, amount);
        
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }
    
    public Account getAccountById(@NotNull UUID id) {
        return findAccountById(id);
    }
    
    public Account getAccountByNumber(@NotBlank String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
            .orElseThrow(() -> new AccountNotFoundException(
                "Cuenta no encontrada con número: " + accountNumber
            ));
    }
    
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    public List<Account> getAccountsByHolder(@NotBlank String holderName) {
        return accountRepository.findByAccountHolderContainingIgnoreCase(holderName);
    }
    
    public List<Account> getAccountsByStatus(@NotNull AccountStatus status) {
        return accountRepository.findByStatus(status);
    }
    
    public void deactivateAccount(@NotNull UUID accountId) {
        Account account = findAccountById(accountId);
        account.setStatus(AccountStatus.INACTIVE);
        account.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(account);
    }
    
    public void activateAccount(@NotNull UUID accountId) {
        Account account = findAccountById(accountId);
        account.setStatus(AccountStatus.ACTIVE);
        account.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(account);
    }
    
    public void deleteAccount(@NotNull UUID accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new AccountNotFoundException(
                "Cuenta no encontrada con ID: " + accountId
            );
        }
        accountRepository.deleteById(accountId);
    }
    
    public long getTotalAccounts() {
        return accountRepository.count();
    }
    
    private Account findAccountById(UUID id) {
        return accountRepository.findById(id)
            .orElseThrow(() -> new AccountNotFoundException(
                "Cuenta no encontrada con ID: " + id
            ));
    }
    
    private void validateAccountNumberNotExists(String accountNumber) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException(
                "Ya existe una cuenta con el número: " + accountNumber
            );
        }
    }
    
    private void validateInitialBalance(BigDecimal balance) {
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                "El saldo inicial no puede ser negativo"
            );
        }
    }
    
    public static class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/com/bankaccount/infrastructure/adapters/AccountRepositoryAdapter.java ===
package com.bankaccount.infrastructure.adapters;


import com.bankaccount.domain.model.AccountStatus;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.ports.AccountRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class AccountRepositoryAdapter implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account save(Account account) {
        if (account.getId() == null) {
            account = createNewAccount(account);
        } else {
            account = updateExistingAccount(account);
        }
        return account;
    }

    private Account createNewAccount(Account account) {
        entityManager.persist(account);
        entityManager.flush();
        entityManager.refresh(account);
        return account;
    }

    private Account updateExistingAccount(Account account) {
        account.setUpdatedAt(LocalDateTime.now());
        return entityManager.merge(account);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        Account account = entityManager.find(Account.class, id);
        return Optional.ofNullable(account);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber", Account.class);
        query.setParameter("accountNumber", accountNumber);
        List<Account> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a", Account.class);
        return query.getResultList();
    }

    @Override
    public void delete(Account account) {
        if (entityManager.contains(account)) {
            entityManager.remove(account);
        } else {
            entityManager.remove(entityManager.merge(account));
        }
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        TypedQuery<Long> query = entityManager.createQuery(
            "SELECT COUNT(a) FROM Account a WHERE a.accountNumber = :accountNumber", Long.class);
        query.setParameter("accountNumber", accountNumber);
        return query.getSingleResult() > 0;
    }

    @Override
    public List<Account> findByAccountHolder(String accountHolder) {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a WHERE a.accountHolder = :accountHolder", Account.class);
        query.setParameter("accountHolder", accountHolder);
        return query.getResultList();
    }

    @Override
    public List<Account> findByStatus(Account.AccountStatus status) {
        TypedQuery<Account> query = entityManager.createQuery(
            "SELECT a FROM Account a WHERE a.status = :status", Account.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public BigDecimal getTotalBalanceByAccountHolder(String accountHolder) {
        TypedQuery<BigDecimal> query = entityManager.createQuery(
            "SELECT COALESCE(SUM(a.balance), 0) FROM Account a WHERE a.accountHolder = :accountHolder",
            BigDecimal.class);
        query.setParameter("accountHolder", accountHolder);
        return query.getSingleResult();
    }
}

// === ARCHIVO: src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java ===
package com.bankaccount.infrastructure.controllers;

import com.bankaccount.application.AccountService;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.Account.AccountStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        Account createdAccount = accountService.createAccount(
            request.accountNumber(),
            request.accountHolder(),
            request.accountType(),
            request.initialBalance()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable UUID id) {
        return accountService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        return accountService.findByAccountNumber(accountNumber)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/holder/{accountHolder}")
    public ResponseEntity<List<Account>> getAccountsByHolder(@PathVariable String accountHolder) {
        List<Account> accounts = accountService.findByAccountHolder(accountHolder);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Account>> getAccountsByStatus(@PathVariable AccountStatus status) {
        List<Account> accounts = accountService.findByStatus(status);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<Account> deposit(
            @PathVariable UUID id,
            @Valid @RequestBody TransactionRequest request) {
        return accountService.findById(id)
            .map(account -> {
                accountService.deposit(account, request.amount());
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Account> withdraw(
            @PathVariable UUID id,
            @Valid @RequestBody TransactionRequest request) {
        return accountService.findById(id)
            .map(account -> {
                accountService.withdraw(account, request.amount());
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/transfer")
    public ResponseEntity<Account> transfer(
            @PathVariable UUID id,
            @Valid @RequestBody TransferRequest request) {
        return accountService.findById(id)
            .map(sourceAccount -> {
                return accountService.findByAccountNumber(request.targetAccountNumber())
                    .map(targetAccount -> {
                        accountService.transfer(sourceAccount, targetAccount, request.amount());
                        return ResponseEntity.ok(sourceAccount);
                    })
                    .orElse(ResponseEntity.notFound().build());
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/apply-interest")
    public ResponseEntity<Account> applyInterest(@PathVariable UUID id) {
        return accountService.findById(id)
            .map(account -> {
                accountService.applyInterest(account);
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable UUID id) {
        return accountService.findById(id)
            .map(account -> {
                accountService.deleteAccount(account);
                return ResponseEntity.noContent().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Account> updateStatus(
            @PathVariable UUID id,
            @Valid @RequestBody StatusUpdateRequest request) {
        return accountService.findById(id)
            .map(account -> {
                accountService.updateStatus(account, request.status());
                return ResponseEntity.ok(account);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/holder/{accountHolder}/total-balance")
    public ResponseEntity<Map<String, BigDecimal>> getTotalBalance(
            @PathVariable String accountHolder) {
        BigDecimal total = accountService.getTotalBalanceByAccountHolder(accountHolder);
        return ResponseEntity.ok(Map.of("totalBalance", total));
    }

    public record CreateAccountRequest(
        @NotBlank String accountNumber,
        @NotBlank String accountHolder,
        @NotBlank String accountType,
        @Positive BigDecimal initialBalance
    ) {}

    public record TransactionRequest(@NotNull @Positive BigDecimal amount) {}

    public record TransferRequest(
        @NotBlank String targetAccountNumber,
        @NotNull @Positive BigDecimal amount
    ) {}

    public record StatusUpdateRequest(@NotNull AccountStatus status) {}
}

// === ARCHIVO: src/test/java/com/bankaccount/domain/model/AccountTest.java ===
package com.bankaccount.domain.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas unitarias para el modelo de Account")
class AccountTest {

    @Test
    @DisplayName("Crear SavingsAccount con datos válidos")
    @Disabled("Completar implementación")
    void shouldCreateSavingsAccountWithValidData() {
        // Given: datos válidos para una cuenta de ahorro
        UUID id = UUID.randomUUID();
        String accountNumber = "SAV-001";
        String accountHolder = "Juan Pérez";
        BigDecimal initialBalance = new BigDecimal("1000.00");
        BigDecimal interestRate = new BigDecimal("0.05");

        // When: se crea la cuenta de ahorro
        SavingsAccount account = new SavingsAccount(id, accountNumber, accountHolder, initialBalance, interestRate);

        // Then: los valores se asignan correctamente
        assertEquals(id, account.getId());
        assertEquals(accountNumber, account.getAccountNumber());
        assertEquals(accountHolder, account.getAccountHolder());
        assertEquals(initialBalance, account.getBalance());
        assertEquals(interestRate, account.getInterestRate());
    }

    @Test
    @DisplayName("Crear CurrentAccount con datos válidos")
    @Disabled("Completar implementación")
    void shouldCreateCurrentAccountWithValidData() {
        // Given: datos válidos para una cuenta corriente
        UUID id = UUID.randomUUID();
        String accountNumber = "CUR-001";
        String accountHolder = "María García";
        BigDecimal initialBalance = new BigDecimal("500.00");
        BigDecimal overdraftLimit = new BigDecimal("200.00");

        // When: se crea la cuenta corriente
        CurrentAccount account = new CurrentAccount(id, accountNumber, accountHolder, initialBalance, overdraftLimit);

        // Then: los valores se asignan correctamente
        assertEquals(id, account.getId());
        assertEquals(accountNumber, account.getAccountNumber());
        assertEquals(accountHolder, account.getAccountHolder());
        assertEquals(initialBalance, account.getBalance());
        assertEquals(overdraftLimit, account.getOverdraftLimit());
    }

    @Test
    @DisplayName("Depósito exitoso en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldDepositSuccessfullyInSavingsAccount() {
        // Given: una cuenta de ahorro con saldo inicial
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-002",
            "Pedro López",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        BigDecimal depositAmount = new BigDecimal("500.00");

        // When: se realiza un depósito
        account.deposit(depositAmount);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("1500.00"), account.getBalance());
    }

    @Test
    @DisplayName("Retiro exitoso en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldWithdrawSuccessfullyInSavingsAccount() {
        // Given: una cuenta de ahorro con saldo suficiente
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-003",
            "Ana Martínez",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        BigDecimal withdrawAmount = new BigDecimal("300.00");

        // When: se realiza un retiro
        account.withdraw(withdrawAmount);

        // Then: el saldo disminuye
        assertEquals(new BigDecimal("700.00"), account.getBalance());
    }

    @Test
    @DisplayName("Retiro fallido por saldo insuficiente en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldFailWithdrawDueToInsufficientFundsInSavingsAccount() {
        // Given: una cuenta de ahorro con saldo limitado
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-004",
            "Carlos Ruiz",
            new BigDecimal("100.00"),
            new BigDecimal("0.05")
        );
        BigDecimal withdrawAmount = new BigDecimal("500.00");

        // When/Then: el retiro lanza InsufficientFundsException
        assertThrows(Account.InsufficientFundsException.class, () -> {
            account.withdraw(withdrawAmount);
        });
    }

    @Test
    @DisplayName("Transferencia exitosa entre cuentas")
    @Disabled("Completar implementación")
    void shouldTransferSuccessfullyBetweenAccounts() {
        // Given: dos cuentas con saldo
        SavingsAccount sourceAccount = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-005",
            "Origen",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        SavingsAccount targetAccount = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-006",
            "Destino",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );
        BigDecimal transferAmount = new BigDecimal("300.00");

        // When: se realiza la transferencia
        sourceAccount.transfer(targetAccount, transferAmount);

        // Then: ambos saldos se actualizan correctamente
        assertEquals(new BigDecimal("700.00"), sourceAccount.getBalance());
        assertEquals(new BigDecimal("800.00"), targetAccount.getBalance());
    }

    @Test
    @DisplayName("Aplicar interés en SavingsAccount")
    @Disabled("Completar implementación")
    void shouldApplyInterestToSavingsAccount() {
        // Given: una cuenta de ahorro con tasa de interés
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-007",
            "Inversor",
            new BigDecimal("1000.00"),
            new BigDecimal("0.10")
        );

        // When: se aplica el interés
        account.applyInterest();

        // Then: el saldo aumenta en un 10%
        assertEquals(new BigDecimal("1100.00"), account.getBalance());
    }

    @Test
    @DisplayName("Depósito exitoso en CurrentAccount")
    @Disabled("Completar implementación")
    void shouldDepositSuccessfullyInCurrentAccount() {
        // Given: una cuenta corriente
        CurrentAccount account = new CurrentAccount(
            UUID.randomUUID(),
            "CUR-002",
            "Empresa SA",
            new BigDecimal("1000.00"),
            new BigDecimal("500.00")
        );
        BigDecimal depositAmount = new BigDecimal("200.00");

        // When: se realiza un depósito
        account.deposit(depositAmount);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("1200.00"), account.getBalance());
    }

    @Test
    @DisplayName("Retiro con overdraft en CurrentAccount")
    @Disabled("Completar implementación")
    void shouldWithdrawWithOverdraftInCurrentAccount() {
        // Given: una cuenta corriente con overdraft
        CurrentAccount account = new CurrentAccount(
            UUID.randomUUID(),
            "CUR-003",
            "Negocios",
            new BigDecimal("100.00"),
            new BigDecimal("200.00")
        );
        BigDecimal withdrawAmount = new BigDecimal("250.00");

        // When: se realiza un retiro que usa el overdraft
        account.withdraw(withdrawAmount);

        // Then: el saldo puede quedar negativo dentro del límite
        assertTrue(account.getBalance().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(account.getBalance().compareTo(new BigDecimal("-200.00")) >= 0);
    }

    @Test
    @DisplayName("Validar que el depósito no acepta montos negativos")
    @Disabled("Completar implementación")
    void shouldNotAcceptNegativeDepositAmount() {
        // Given: una cuenta de ahorro
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-008",
            "Test",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );

        // When/Then: depósito con monto negativo lanza excepción
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(new BigDecimal("-100.00"));
        });
    }

    @Test
    @DisplayName("Validar que el retiro no acepta montos negativos")
    @Disabled("Completar implementación")
    void shouldNotAcceptNegativeWithdrawAmount() {
        // Given: una cuenta de ahorro
        SavingsAccount account = new SavingsAccount(
            UUID.randomUUID(),
            "SAV-009",
            "Test",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );

        // When/Then: retiro con monto negativo lanza excepción
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(new BigDecimal("-50.00"));
        });
    }
}

// === ARCHIVO: src/test/java/com/bankaccount/application/AccountServiceTest.java ===
package com.bankaccount.application;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bankaccount.domain.model.Account;
import com.bankaccount.domain.model.SavingsAccount;
import com.bankaccount.domain.model.CurrentAccount;
import com.bankaccount.domain.ports.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas unitarias para AccountService")
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    @DisplayName("Crear cuenta de ahorro exitosamente")
    @Disabled("Completar implementación")
    void shouldCreateSavingsAccountSuccessfully() {
        // Given: datos válidos para cuenta de ahorro
        String accountHolder = "Nuevo Cliente";
        BigDecimal initialBalance = new BigDecimal("1000.00");
        BigDecimal interestRate = new BigDecimal("0.05");
        
        when(accountRepository.save(any(SavingsAccount.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        // When: se crea la cuenta
        Account created = accountService.createSavingsAccount(accountHolder, initialBalance, interestRate);

        // Then: la cuenta se guarda y retorna con datos correctos
        assertNotNull(created);
        assertEquals(accountHolder, created.getAccountHolder());
        assertEquals(initialBalance, created.getBalance());
        verify(accountRepository, times(1)).save(any(SavingsAccount.class));
    }

    @Test
    @DisplayName("Crear cuenta corriente exitosamente")
    @Disabled("Completar implementación")
    void shouldCreateCurrentAccountSuccessfully() {
        // Given: datos válidos para cuenta corriente
        String accountHolder = "Empresa Test";
        BigDecimal initialBalance = new BigDecimal("2000.00");
        BigDecimal overdraftLimit = new BigDecimal("500.00");
        
        when(accountRepository.save(any(CurrentAccount.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        // When: se crea la cuenta
        Account created = accountService.createCurrentAccount(accountHolder, initialBalance, overdraftLimit);

        // Then: la cuenta se guarda y retorna con datos correctos
        assertNotNull(created);
        assertEquals(accountHolder, created.getAccountHolder());
        assertEquals(initialBalance, created.getBalance());
        verify(accountRepository, times(1)).save(any(CurrentAccount.class));
    }

    @Test
    @DisplayName("Depositar en cuenta existente")
    @Disabled("Completar implementación")
    void shouldDepositInExistingAccount() {
        // Given: una cuenta existente en el repositorio
        UUID accountId = UUID.randomUUID();
        SavingsAccount existingAccount = new SavingsAccount(
            accountId,
            "SAV-010",
            "Titular",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BigDecimal depositAmount = new BigDecimal("250.00");

        // When: se deposita
        Account result = accountService.deposit(accountId, depositAmount);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("750.00"), result.getBalance());
        verify(accountRepository, times(1)).findById(accountId);
        verify(accountRepository, times(1)).save(existingAccount);
    }

    @Test
    @DisplayName("Retirar de cuenta existente")
    @Disabled("Completar implementación")
    void shouldWithdrawFromExistingAccount() {
        // Given: una cuenta con saldo
        UUID accountId = UUID.randomUUID();
        SavingsAccount existingAccount = new SavingsAccount(
            accountId,
            "SAV-011",
            "Titular",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BigDecimal withdrawAmount = new BigDecimal("400.00");

        // When: se retira
        Account result = accountService.withdraw(accountId, withdrawAmount);

        // Then: el saldo disminuye
        assertEquals(new BigDecimal("600.00"), result.getBalance());
    }

    @Test
    @DisplayName("Transferir entre cuentas")
    @Disabled("Completar implementación")
    void shouldTransferBetweenAccounts() {
        // Given: cuenta origen y cuenta destino
        UUID sourceId = UUID.randomUUID();
        UUID targetId = UUID.randomUUID();
        
        SavingsAccount sourceAccount = new SavingsAccount(
            sourceId,
            "SAV-012",
            "Origen",
            new BigDecimal("1000.00"),
            new BigDecimal("0.05")
        );
        
        SavingsAccount targetAccount = new SavingsAccount(
            targetId,
            "SAV-013",
            "Destino",
            new BigDecimal("500.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(sourceId)).thenReturn(Optional.of(sourceAccount));
        when(accountRepository.findById(targetId)).thenReturn(Optional.of(targetAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        BigDecimal transferAmount = new BigDecimal("300.00");

        // When: se transfiere
        boolean result = accountService.transfer(sourceId, targetId, transferAmount);

        // Then: transferencia exitosa
        assertTrue(result);
        verify(accountRepository, times(2)).save(any(Account.class));
    }

    @Test
    @DisplayName("Fallar transferencia por cuenta origen no encontrada")
    @Disabled("Completar implementación")
    void shouldFailTransferWhenSourceAccountNotFound() {
        // Given: cuenta origen no existe
        UUID sourceId = UUID.randomUUID();
        UUID targetId = UUID.randomUUID();
        
        when(accountRepository.findById(sourceId)).thenReturn(Optional.empty());

        // When/Then: transferencia falla
        assertThrows(RuntimeException.class, () -> {
            accountService.transfer(sourceId, targetId, new BigDecimal("100.00"));
        });
    }

    @Test
    @DisplayName("Obtener cuenta por ID")
    @Disabled("Completar implementación")
    void shouldGetAccountById() {
        // Given: cuenta existente
        UUID accountId = UUID.randomUUID();
        SavingsAccount existingAccount = new SavingsAccount(
            accountId,
            "SAV-014",
            "Buscada",
            new BigDecimal("800.00"),
            new BigDecimal("0.05")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(existingAccount));

        // When: se busca la cuenta
        Optional<Account> result = accountService.getAccountById(accountId);

        // Then: se encuentra la cuenta
        assertTrue(result.isPresent());
        assertEquals(accountId, result.get().getId());
    }

    @Test
    @DisplayName("Obtener todas las cuentas")
    @Disabled("Completar implementación")
    void shouldGetAllAccounts() {
        // Given: múltiples cuentas en el repositorio
        // When: se obtienen todas las cuentas
        // Then: se retornan todas
        verify(accountRepository, never()).findAll();
    }

    @Test
    @DisplayName("Depositar en cuenta inexistente debe fallar")
    @Disabled("Completar implementación")
    void shouldFailDepositWhenAccountNotFound() {
        // Given: cuenta no existe
        UUID accountId = UUID.randomUUID();
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // When/Then: depósito falla
        assertThrows(RuntimeException.class, () -> {
            accountService.deposit(accountId, new BigDecimal("100.00"));
        });
    }

    @Test
    @DisplayName("Retirar de cuenta inexistente debe fallar")
    @Disabled("Completar implementación")
    void shouldFailWithdrawWhenAccountNotFound() {
        // Given: cuenta no existe
        UUID accountId = UUID.randomUUID();
        when(accountRepository.findById(accountId)).thenReturn(Optional.empty());

        // When/Then: retiro falla
        assertThrows(RuntimeException.class, () -> {
            accountService.withdraw(accountId, new BigDecimal("100.00"));
        });
    }

    @Test
    @DisplayName("Aplicar interés a cuenta de ahorro")
    @Disabled("Completar implementación")
    void shouldApplyInterestToSavingsAccount() {
        // Given: cuenta de ahorro
        UUID accountId = UUID.randomUUID();
        SavingsAccount savingsAccount = new SavingsAccount(
            accountId,
            "SAV-015",
            "Inversor",
            new BigDecimal("1000.00"),
            new BigDecimal("0.10")
        );
        
        when(accountRepository.findById(accountId)).thenReturn(Optional.of(savingsAccount));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When: se aplica interés
        Account result = accountService.applyInterest(accountId);

        // Then: el saldo aumenta
        assertEquals(new BigDecimal("1100.00"), result.getBalance());
    }
}
```
