# Filmoteca — Entorno de Desarrollo (Android)
Autor: Carlos Alfredo Callagua Llaque

## Contenido
- Ejercicio 1: Creación del proyecto (AboutActivity, paquete `es.ua.eps.filmoteca`, minSdk 24)
- Ejercicio 2: Ejecución en emulador/dispositivo
- Ejercicio 3: About con autor, imagen y 3 botones (Toasts)
- Ejercicio 4: Internacionalización ES/EN (strings.xml y values-en)
- Ejercicio 5: Conmutación Layouts vs Compose (enum Mode, initUI)

## Build
- Android Gradle Plugin 8.6.x, Kotlin 1.9.25
- targetSdk 36, minSdk 24
- Para compilar: `Build > Rebuild Project`, ejecutar sobre AVD o dispositivo real.

---

**SEGUNDO GRUPO DE EJERCICIOS (Filmoteca - Itens 1–5)**

A continuación se detallan los ejercicios del segundo bloque realizados en el proyecto **Filmoteca**, correspondientes a los temas de navegación, menús y Jetpack Compose:



*(Contenido añadido el 2025-10-25 por Carlos Callagua)*

------------------------------------------------------------------------------------------------------------------------------


#  Filmoteca — Ejercicios 1–5 (EJERCICIOS ITENS)
#  Ejercicios implementados

# **Ejercicio 1 — AboutActivity**
- Implementación básica de una actividad informativa.  
- Uso de `Toast`, `Intent` y recursos (`stringResource`, `painterResource`).
- Modo clásico y modo `Compose`.

---

**Ejercicio 2 — MainActivity (Navegación explícita)**
- Uso de botones que redirigen a otras pantallas (`AboutActivity`, `FilmListActivity`).
- Configuración del `AndroidManifest.xml` con `intent-filter` principal.
- Implementación de `enableEdgeToEdge()` y `ViewCompat` para ajuste dinámico de márgenes.

---

**Ejercicio 3 — Lista XML con RecyclerView**
- Creación de `FilmListActivity` y `FilmAdapter` (RecyclerView + ViewHolder).
- Definición de modelos: `Film.kt` y `SampleData.kt`.
- Navegación hacia `FilmDetailActivity` al seleccionar una película.
- Layouts XML: `activity_film_list.xml`, `item_film.xml`, `activity_film_detail.xml`.

---

**Ejercicio 4 — Menú principal**
- Inclusión de menú de opciones (`menu_main.xml`) con:
  - “About”
  - “Web” (abre GitHub del autor)
  - “Share” (envía texto mediante apps externas)
- Muestra práctica de `MenuInflater` y `onOptionsItemSelected()`.

---

**Ejercicio 5 — Jetpack Compose**
- Creación de `FilmListComposeActivity` y `FilmDetailComposeActivity`.
- Uso de `Scaffold`, `TopAppBar`, `LazyColumn`, `MaterialTheme`.
- Interacción con `Intent` y paso de parámetros entre pantallas.
- Botón de navegación “←” funcional dentro del `TopAppBar`.

