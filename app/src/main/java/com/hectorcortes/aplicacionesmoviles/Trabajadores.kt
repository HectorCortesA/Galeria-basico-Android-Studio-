package com.hectorcortes.aplicacionesmoviles

class Trabajadores(
    val id: Int,
    val nombre: String,
    val horasClaseSemana: Int,
    val sueldoHora: Double,
    val facultad: String,
    val antiguedad: Int
) {
    fun sueldoXMes(): Double {
        val horasClaseMes = horasClaseSemana * 4
        return horasClaseMes * sueldoHora
    }
    fun mostrarInfo() {
        println("ID: $id")
        println("Nombre: $nombre")
        println("Facultad: $facultad")
        println("Antigüedad: $antiguedad años")
        println("Sueldo mensual: ${sueldoXMes()}")
    }
}

fun ingresarTrabajador(): Trabajadores? {
    println("Ingresa su ID: ")
    val id = readLine()?.toIntOrNull()
    println("Ingresa su nombre: ")
    val nombre = readLine().orEmpty()
    println("Ingresa sus horas de clase por semana: ")
    val horasClaseSemana = readLine()?.toIntOrNull()
    println("Ingresa su sueldo por hora: ")
    val sueldoHora = readLine()?.toDoubleOrNull()
    println("Ingrese su facultad: ")
    val facultad = readLine().orEmpty()
    println("Ingrese su antigüedad: ")
    val antiguedad = readLine()?.toIntOrNull()

    if (id != null && horasClaseSemana != null && sueldoHora != null && antiguedad != null) {
        return Trabajadores(id, nombre, horasClaseSemana, sueldoHora, facultad, antiguedad)
    } else {
        println("Datos ingresados no válidos.")
        return null
    }
}

fun buscarTrabajador(listaTrabajadores: ArrayList<Trabajadores>, id: Int): Trabajadores? {
    return listaTrabajadores.find { it.id == id }
}

fun main() {
    val listaTrabajadores = ArrayList<Trabajadores>()

    while (true) {
        println("\nMenú")
        println("1.Ingresar un nuevo trabajador")
        println("2.Buscar un trabajador existente")
        println("3.Salir")
        print("Seleccione una opción: ")
        when (readLine()) {
            "1" -> {
                val nuevoTrabajador = ingresarTrabajador()
                if (nuevoTrabajador != null) {
                    listaTrabajadores.add(nuevoTrabajador)
                    println("Trabajador agregado exitosamente.")
                }
            }
            "2" -> {
                println("Ingresa el ID del trabajador que deseas buscar: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    val trabajador = buscarTrabajador(listaTrabajadores, id)
                    if (trabajador != null) {
                        trabajador.mostrarInfo()
                        println("\n¿Qué dato desea consultar?")
                        println("1. Nombre")
                        println("2. Facultad")
                        println("3. Antigüedad")
                        println("4. Sueldo mensual")
                        when (readLine()) {
                            "1" -> println("Nombre: ${trabajador.nombre}")
                            "2" -> println("Facultad: ${trabajador.facultad}")
                            "3" -> println("Antigüedad: ${trabajador.antiguedad} años")
                            "4" -> println("Sueldo mensual: ${trabajador.sueldoXMes()}")
                            else -> println("Opción no válida.")
                        }
                    } else {
                        println("Trabajador no encontrado.")
                    }
                } else {
                    println("ID no válido.")
                }
            }
            "3" -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción no válida. Intente de nuevo.")
        }
    }
}
