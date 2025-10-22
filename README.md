cat > README.md <<'EOF'
# Filmoteca — Entorno de Desarrollo (Android)
Autor: Carlos Alfredo Callagua Llaque

## Contenido
- Ejercicio 1: creación del proyecto (AboutActivity, paquete "es.ua.eps.filmoteca", minSdk 24)
- Ejercicio 2: ejecución en emulador/dispositivo
- Ejercicio 3: About con autor, imagen y 3 botones (Toasts)
- Ejercicio 4: Internacionalización ES/EN (strings.xml y values-en)
- Ejercicio 5: Conmutación Layouts vs Compose 

## Build
- Android Gradle Plugin 8.6.x, Kotlin 1.9.25
- targetSdk 36, minSdk 24
- Para compilar: "Build > Rebuild Project", ejecutar sobre AVD o dispositivo real.

EOF(inicio/ final)
git add README.md
git commit -m "README con resumen de ejercicios"
git push
