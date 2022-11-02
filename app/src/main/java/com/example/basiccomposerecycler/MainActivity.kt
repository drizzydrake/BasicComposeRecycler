package com.example.basiccomposerecycler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccomposerecycler.ui.theme.BasicComposeRecyclerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeRecyclerTheme {

                DetailsContent()

            }
        }
    }
}

@Composable
fun StudentCard(student: Details) {
    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        //defaultElevation: 2.dp,
       // elevation = 2.dp,
      //  backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    )    {
        Row(modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Max)
            .padding(20.dp)) {

            Text(
                text = student.title,
                style = TextStyle(
                        color = Color.Black,
                    fontSize = 22.sp
                        )
            )
        }

    }

}


@Composable
fun DetailsContent(){
    val studentList = remember{
        StudentDetails.studentDetailsList
    }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){

        items(
            studentList
        ){
            StudentCard(student = it)
        }
    }
}

