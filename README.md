# Aplicación de OOP en un Sistema de Gestión de Cuentas Bancarias

El sistema de gestión de cuentas bancarias requiere la aplicación de principios de OOP para manejar diferentes tipos de cuentas (ahorro, corriente, inversión) y operaciones (depósito, retiro, transferencia). El sistema debe ser capaz de manejar múltiples cuentas y realizar operaciones de manera idempotente, asegurando que los retiros no superen el saldo disponible y que los depósitos sean mayores a cero.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Desarrollo de Software con OOP |
| **Nivel** | advanced-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Modelado de Cuentas Bancarias

**Objetivo:** Definir y modelar las diferentes clases de cuentas bancarias utilizando principios de OOP.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar y definir las clases base y derivadas para representar diferentes tipos de cuentas.
- Establecer relaciones de herencia y polimorfismo para manejar operaciones comunes y específicas de cada tipo de cuenta.

**Entregable:** Diagrama de clases y descripción de las relaciones de herencia y polimorfismo.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo las clases base y derivadas pueden compartir funcionalidad común.
- Piensa en cómo las operaciones específicas de cada tipo de cuenta pueden ser manejadas de manera polimórfica.

</details>

### Fase 2: Implementación de Operaciones

**Objetivo:** Implementar operaciones básicas (depósito, retiro, transferencia) en las clases de cuentas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar métodos para realizar depósitos y retiros en las clases de cuentas.
- Asegurar que los retiros no superen el saldo disponible y que los depósitos sean mayores a cero.
- Implementar la operación de transferencia entre cuentas.

**Entregable:** Código implementado para las operaciones de depósito, retiro y transferencia en las clases de cuentas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar los errores de operación (por ejemplo, saldo insuficiente).
- Piensa en cómo asegurar la idempotencia de las operaciones.

</details>

### Fase 3: Pruebas y Refactorización

**Objetivo:** Realizar pruebas unitarias y refactorizar el código para mejorar su calidad y mantenibilidad.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribir pruebas unitarias para verificar el comportamiento correcto de las operaciones implementadas.
- Refactorizar el código para mejorar su calidad y mantenibilidad, aplicando principios de OOP y buenas prácticas de codificación.

**Entregable:** Código refactorizado y pruebas unitarias implementadas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo aplicar principios de OOP y buenas prácticas de codificación para mejorar la calidad y mantenibilidad del código.
- Piensa en cómo escribir pruebas unitarias efectivas para verificar el comportamiento correcto de las operaciones.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los principios de OOP y cómo se aplican en la modelación de clases?
- **paraQueSirve**: ¿Para qué sirven las relaciones de herencia y polimorfismo en la gestión de cuentas bancarias?
- **comoSeUsa**: ¿Cómo se implementan operaciones básicas (depósito, retiro, transferencia) en las clases de cuentas?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar operaciones en las clases de cuentas y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones implica la refactorización del código para mejorar su calidad y mantenibilidad?

## Criterios de Evaluacion

- Modelación correcta de clases utilizando principios de OOP.
- Implementación correcta de operaciones básicas (depósito, retiro, transferencia) en las clases de cuentas.
- Manejo efectivo de errores de operación.
- Aseguramiento de la idempotencia de las operaciones.
- Refactorización del código para mejorar su calidad y mantenibilidad.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
