package com.example.waterme.data

import com.example.waterme.R
import com.example.waterme.model.Plant

object DataSource {
   val plants = listOf(
       Plant(
           name = "Lithop",
           schedule = "monthly",
           type = "Succulent",
           description = "Stone mimicking succulent",
           imageId = R.drawable.a


       ),
       Plant(
           name = "Carrot",
           schedule = "daily",
           type = "Root",
           description = "Hardy root vegetable",
           imageId = R.drawable.b
       ),
       Plant(
           name = "Peony",
           schedule = "weekly",
           type = "Flower",
           description = "Spring blooming flower",
           imageId = R.drawable.c
       ),
//       Plant(
//           name = "Pothos",
//           schedule = "weekly",
//           type = "Houseplant",
//           description = "Indoor vine"
//       ),
//       Plant(
//           name = "Fiddle Leaf Fig",
//           schedule = "weekly",
//           type = "Broadleaf evergreen",
//           description = "Ornamental fig"
//       ),
//       Plant(
//           name = "Strawberry",
//           schedule = "daily",
//           type = "Fruit",
//           description = "Delicious 'multiple fruit'"
//       )
   )
}
