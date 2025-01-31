package com.example.jetpackcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme.colors
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.Book


@Composable
fun BooksGridScreen(
    books: List<Book>, // Принимает список книг
    modifier: Modifier, // Принимает модификатор для внешнего оформлени
    onBookClicked: (Book) -> Unit
) {
    // Создаем вертикальную сетку с адаптивным количеством колонок
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp), // Устанавливаем адаптивные колонки с минимальной шириной 150 dp
        contentPadding = PaddingValues(4.dp) // Устанавливаем отступы по краям списка в 4 dp
    ) {
        // Итерируемся по списку книг с использованием индексов
        itemsIndexed(books) { _, book ->
            // Создаем карточку для каждой книги
            BooksCard(book = book, modifier, onBookClicked)
        }
    }
}

@Composable
fun BooksCard(
    book: Book, // Принимаем объект книги
    modifier: Modifier = Modifier, // Принимаем модификатор, по умолчанию - пустой
//    elevation: CardElevation = CardDefaults.cardElevation(8.dp), // Устанавливаем эффект приподнятия карточки
    onBookClicked: (Book) -> Unit,
    backgroundColor: Color = Color.White
) {

    // Создаем карточку с указанным модификатором и эффектом приподнятия
    Card(
        modifier = modifier
            .padding(4.dp) // Устанавливаем внутренние отступы карточки
            .fillMaxWidth() // Заполняем доступную ширину
            .requiredHeight(280.dp) // Устанавливаем фиксированную высоту в 300 dp
            .clickable { onBookClicked(book) },
        elevation = CardDefaults.cardElevation(8.dp), // Применяем эффект приподнятия

    ) {
        // Создаем вертикальный столбец для содержимого карточки
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Проверяем наличие заголовка книги
            book.title?.let {
                // Если заголовок есть, отображаем текст
                Text(
                    text = it, // Устанавливаем текст заголовка
                    fontSize = 14.sp,
                    color = Color.Black,
//                    textAlign = TextAlign.Center, // Выравниваем текст по центру
                    modifier = modifier
                        .padding(top = 4.dp, bottom = 8.dp) // Устанавливаем отступы сверху и снизу
                )
            }
            // Загружаем изображение книги асинхронно
            AsyncImage(
                modifier = modifier.fillMaxWidth(), // Устанавливаем ширину изображения, равной ширине карточки
                model = ImageRequest.Builder(context = LocalContext.current) // Создаем запрос на загрузку изображения
                    .data(book.imageLink) // Устанавливаем ссылку на изображение книги
                    .crossfade(true) // Включаем плавный переход при загрузке
                    .build(),
                error = painterResource(id = R.drawable.ic_book_96), // Устанавливаем ресурс для отображения в случае ошибки загрузки
                placeholder = painterResource(id = R.drawable.loading_img), // Устанавливаем ресурс для отображения во время загрузки
                contentDescription = stringResource(id = R.string.content_description), // Устанавливаем строку состояния для доступности
                contentScale = ContentScale.Crop // Масштабируем изображение с обрезкой
            )
        }
    }
}
//@Preview
//@Composable
//fun Preview() = BooksCard(
//    book = Book(
//        title = " title",
//        previewLink =" title" ,
//        imageLink = "dsdssd"
//    )
//)
