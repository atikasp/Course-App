package com.example.compose_course

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_course.data.Datasource
import com.example.compose_course.model.Courses
import com.example.compose_course.ui.theme.Compose_CourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_CourseTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CoursesApp()
                }
            }
        }
    }
}


@Composable
fun CoursesApp(){
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),
            ),
    ) {
        CoursesList(
            coursesList = Datasource().loadCourses()
        )
    }
}


@SuppressLint("ResourceType")
@Composable
fun CourseCard(courses: Courses, modifier: Modifier = Modifier){
    Card(modifier = modifier.padding(8.dp)) {
        Row{
            Image(
                painter = painterResource(courses.coursesImageId),
                contentDescription = stringResource(courses.coursesNameId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = LocalContext.current.getString(courses.coursesNameId),
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom =8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 1
                )
                Row{
                    Icon(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = courses.coursesTotalId.toString(),
                        modifier = Modifier.padding(end = 16.dp),
                        style = MaterialTheme.typography.labelMedium
                    )


                }

            }
        }
    }
}

@Composable
fun CoursesList(coursesList: List<Courses>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        modifier = Modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
        items(coursesList) { courses ->
            CourseCard(
                courses = courses,
                modifier = modifier
            )
        }
    }
}

@SuppressLint("ResourceType")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_CourseTheme {
        CoursesApp()
    }
}