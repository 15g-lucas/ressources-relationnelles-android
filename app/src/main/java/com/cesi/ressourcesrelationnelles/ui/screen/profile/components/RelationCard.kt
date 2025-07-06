package com.cesi.ressourcesrelationnelles.ui.screen.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.cesi.ressourcesrelationnelles.data.dto.response.UserRelationDto
import com.cesi.ressourcesrelationnelles.ui.theme.roboto

@Composable
fun RelationCard(
    user: UserRelationDto
) {
    Column(
        modifier = Modifier
            .height(137.dp)
            .width(120.dp)
            .padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = user.profilePicture,
                contentDescription = "User profile picture",
            )
        }


        Text(
            modifier = Modifier
                .width(100.dp)
                .height(22.dp),
            text = "${user.firstName} ${user.lastName}",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = roboto,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            )
        )
    }
}

@Preview
@Composable
fun RelationCardPreview() {
    val user = UserRelationDto(
        id = 1,
        firstName = "Michelle",
        lastName = "Saucisse",
        typeId = 1,
        profilePicture = "toto"
    )
    RelationCard(user)
}