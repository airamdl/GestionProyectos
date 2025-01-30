sealed interface Color {
    data class RGB(val red: Int, val green: Int, val blue: Int) : Color
    data class HEX(val value: String) : Color
    data class RGBA(val red: Int, val green: Int, val blue: Int, val alpha: Float) : Color
}

enum class ModoColor {
    CLARO,
    OSCURO
}

data class Palette(
    val fondo: Color,
    val texto: Color,
    val superficie: Color,
    val borde: Color,
    val accent: Color,
    val error: Color,
    val exito: Color
)

class Colores(private val modo: ModoColor) {

    private val lightPalette = Palette(
        fondo = Color.HEX("#FFFFFF"),
        texto = Color.HEX("#212121"),
        superficie = Color.HEX("#FAFAFA"),
        borde = Color.HEX("#E0E0E0"),
        accent = Color.HEX("#2196F3"),
        error = Color.HEX("#B00020"),
        exito = Color.HEX("#4CAF50")
    )

    // Paleta oscura
    private val darkPalette = Palette(
        fondo = Color.HEX("#121212"),
        texto = Color.HEX("#E0E0E0"),
        superficie = Color.HEX("#1E1E1E"),
        borde = Color.HEX("#373737"),
        accent = Color.HEX("#BB86FC"),
        error = Color.HEX("#CF6679"),
        exito = Color.HEX("#03DAC6")
    )

    val fondo: Color
        get() = currentPalette.fondo

    val texto: Color
        get() = currentPalette.texto

    val superficie: Color
        get() = currentPalette.superficie

    val borde: Color
        get() = currentPalette.borde

    val accent: Color
        get() = currentPalette.accent

    val error: Color
        get() = currentPalette.error

    val exito: Color
        get() = currentPalette.exito

    val modoActual: ModoColor
        get() = modo

    private val currentPalette: Palette
        get() = when (modo) {
            ModoColor.CLARO -> lightPalette
            ModoColor.OSCURO -> darkPalette
        }

    fun toggleModo() = if (modo == ModoColor.CLARO) {
        Colores(ModoColor.OSCURO)
    } else {
        Colores(ModoColor.CLARO)
    }

    fun copiarConModo(nuevoModo: ModoColor) = Colores(nuevoModo)

    companion object {
        // Función de creación con modo predeterminado
        fun crear(modoInicial: ModoColor = ModoColor.CLARO) = Colores(modoInicial)
    }
}

// Extensión para validar colores HEX
private fun validarHEX(valor: String) {
    require(valor.matches(Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})\$"))) {
        "Formato HEX inválido: $valor"
    }
}