package screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

@Composable
fun ProjectScreen() :Screen{
    val navigator = LocalNavigator.current
    val project = Project(
        name = "Proyecto Ejemplo",
        description = "Tareas de proyecto",
        tasks = listOf(
            Task("Tarea 1", "Descripción 1"),
            Task("Tarea 2", "Descripción2"),
            Task("Tarea 3", "Descripción 3")
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Proyecto: ${project.name}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Descripción: ${project.description}",
            fontSize = 16.sp,
            color = MaterialTheme.colors.onSurface
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Tareas del Proyecto",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )

        LazyColumn {
            items(project.tasks) { task ->
                TaskItem(task, onClick = { })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { navigator?.push(TareaScreen())},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White
            )
        ) {
            Text("Asignar Tareas al Proyecto")
        }

        Spacer(modifier = Modifier.height(8.dp))


        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = Color.White
            )
        ) {
            Text("Asignar Programadores al Proyecto")
        }
    }
}

@Composable
fun TaskItem(task: Task, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = task.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = task.description,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

data class Project(
    val name: String,
    val description: String,
    val tasks: List<Task>
)

data class Task(
    val name: String,
    val description: String
)

