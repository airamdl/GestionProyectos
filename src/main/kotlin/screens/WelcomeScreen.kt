package screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

data class Proyecto(val id: Int, val nombre: String, val fecha: String)


class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val proyectosFinalizados = listOf(
            Proyecto(1, "Proyecto1", "20/1/2025"),
            Proyecto(2, "Proyecto2", "20/1/2025"),
            Proyecto(3, "Proyecto3", "20/1/2025"),
            Proyecto(4, "Proyecto4", "20/1/2025"),
            Proyecto(5, "Proyecto5", "20/1/2025"),
            Proyecto(6, "Proyecto6", "20/1/2025"),
            Proyecto(7, "Proyecto7", "20/1/2025"),
            Proyecto(8, "Proyecto8", "20/1/2025"),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFf5f5f5))
                .padding(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFF212121), shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Bienvenido",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Aplicacion alexsoft.",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Ver proyectos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                Button(
                    onClick = {
                        navigator?.push(ProjectsScreen())
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF373737))
                ) {
                    Text(
                        text = "Entrar",
                        color = Color.White
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(7.dp)).background(Color.DarkGray).padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Proyectos activos", fontSize = 25.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Button(
                    onClick = {
                        navigator?.push(ProjectsScreen())
                    },
                    modifier = Modifier.padding(20.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                ) {
                    Text("Ver proyectos", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn(
                modifier = Modifier.height(200.dp)
            ) {
                items(proyectosFinalizados) { proyecto ->
                    ProyectoItem(proyecto)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            Button(
                onClick = {
                    navigator?.pop()
                },
                modifier = Modifier.padding(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text("Cerrar Sesión", color = Color.White)
            }
        }
    }
}

@Composable
fun ProyectoItem(proyecto: Proyecto) {
    var colorFondo = 0xFF372d4f
    if (proyecto.id % 2 == 0){
        colorFondo = 0xFF5f5580
    }
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(7.dp)).background(Color(colorFondo)).padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(proyecto.nombre)
        Text(proyecto.fecha, color = Color.White)
    }
}