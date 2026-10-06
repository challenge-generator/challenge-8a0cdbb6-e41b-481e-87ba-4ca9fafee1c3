# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Aplicación de OOP en un Sistema de Gestión de Cuentas Bancarias**.

| | |
|---|---|
| Tema | Desarrollo de Software con OOP |
| Nivel | advanced-l1 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa 3.5.6
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.projectlombok:lombok 1.18.34
- com.h2database:h2 2.2.224

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Modelado de Cuentas Bancarias**: Diagrama de clases y descripción de las relaciones de herencia y polimorfismo.
- **Fase 2 — Implementación de Operaciones**: Código implementado para las operaciones de depósito, retiro y transferencia en las clases de cuentas.
- **Fase 3 — Pruebas y Refactorización**: Código refactorizado y pruebas unitarias implementadas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/bankaccount/application/AccountServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (35)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/bankaccount/Application.java` — `com.bankaccount.application.config.AccountProperties`
      El import com.bankaccount.application.config.AccountProperties usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/bankaccount/domain/model/Account.java` — `Account.getStatus`
      Se invoca `getStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/domain/model/Account.java` — `Account.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/application/AccountService.java` — `Account.setStatus`
      Se invoca `setStatus` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/application/AccountService.java` — `Account.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/application/AccountService.java` — `AccountRepository.existsById`
      Se invoca `existsById` sobre `AccountRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/adapters/AccountRepositoryAdapter.java` — `Account.getId`
      Se invoca `getId` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/adapters/AccountRepositoryAdapter.java` — `Account.setUpdatedAt`
      Se invoca `setUpdatedAt` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.createAccount`
      Se invoca `createAccount` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.accountNumber`
      Se invoca `accountNumber` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.accountHolder`
      Se invoca `accountHolder` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.accountType`
      Se invoca `accountType` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.initialBalance`
      Se invoca `initialBalance` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findById`
      Se invoca `findById` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findByAccountNumber`
      Se invoca `findByAccountNumber` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findByAccountHolder`
      Se invoca `findByAccountHolder` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.findByStatus`
      Se invoca `findByStatus` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.amount`
      Se invoca `amount` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.targetAccountNumber`
      Se invoca `targetAccountNumber` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.applyInterest`
      Se invoca `applyInterest` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.updateStatus`
      Se invoca `updateStatus` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `StatusUpdateRequest.status`
      Se invoca `status` sobre `StatusUpdateRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java` — `AccountService.getTotalBalanceByAccountHolder`
      Se invoca `getTotalBalanceByAccountHolder` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getId`
      Se invoca `getId` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getAccountNumber`
      Se invoca `getAccountNumber` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getAccountHolder`
      Se invoca `getAccountHolder` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getBalance`
      Se invoca `getBalance` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getInterestRate`
      Se invoca `getInterestRate` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.getOverdraftLimit`
      Se invoca `getOverdraftLimit` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/domain/model/AccountTest.java` — `SavingsAccount.transfer`
      Se invoca `transfer` sobre `SavingsAccount`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.getAccountHolder`
      Se invoca `getAccountHolder` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.getBalance`
      Se invoca `getBalance` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.isPresent`
      Se invoca `isPresent` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `Account.get`
      Se invoca `get` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/bankaccount/application/AccountServiceTest.java` — `AccountService.applyInterest`
      Se invoca `applyInterest` sobre `AccountService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (13)

- `pom.xml`
- `src/main/java/com/bankaccount/Application.java`
- `src/main/resources/application.yml`
- `src/main/java/com/bankaccount/domain/model/Account.java`
- `src/main/java/com/bankaccount/domain/model/SavingsAccount.java`
- `src/main/java/com/bankaccount/domain/model/CurrentAccount.java`
- `src/main/java/com/bankaccount/domain/model/InvestmentAccount.java`
- `src/main/java/com/bankaccount/domain/ports/AccountRepository.java`
- `src/main/java/com/bankaccount/application/AccountService.java`
- `src/main/java/com/bankaccount/infrastructure/adapters/AccountRepositoryAdapter.java`
- `src/main/java/com/bankaccount/infrastructure/controllers/AccountController.java`
- `src/test/java/com/bankaccount/domain/model/AccountTest.java`
- `src/test/java/com/bankaccount/application/AccountServiceTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/bankaccount/domain`
- `src/main/java/com/bankaccount/domain/model`
- `src/main/java/com/bankaccount/domain/ports`
- `src/main/java/com/bankaccount/application`
- `src/main/java/com/bankaccount/infrastructure/adapters`
- `src/main/java/com/bankaccount/infrastructure/controllers`
- `src/test/java/com/bankaccount`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Aplica los principios básicos de la programación orientada a objetos en el código (también conocida como OOP). Esto incluye los pilares de OOP, bucles, genéricos, anotaciones y más.
- Mision: Candidato con experiencia en Backend Java, trabajando en proyectos con enfoque en arquitectura orientada a objetos.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
