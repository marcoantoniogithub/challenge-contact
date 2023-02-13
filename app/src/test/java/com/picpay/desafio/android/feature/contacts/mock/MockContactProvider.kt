package com.picpay.desafio.android.feature.contacts.mock

import com.picpay.desafio.android.feature.contacts.data.remote.dto.UserDTO
import com.picpay.desafio.android.feature.contacts.domain.model.User

object MockContactProvider {

    fun mockedListUserDTO() = listOf<UserDTO>(
        UserDTO(
            img = "https://randomContact.me/api/portraits/men/1.jpg",
            name = "Sandrine Spinka",
            id = 1,
            username = "Tod86"
        ),
        UserDTO(
            img = "https://randomContact.me/api/portraits/men/2.jpg",
            name = "Carli Carroll",
            id = 2,
            username = "Constantin_Sawayn"
        ),
        UserDTO(
            img = "https://randomContact.me/api/portraits/men/3.jpg",
            name = "Annabelle Reilly",
            id = 3,
            username = "Lawrence_Nader62"
        ),
        UserDTO(
            img = "https://randomContact.me/api/portraits/men/4.jpg",
            name = "Mrs. Hilton Welch",
            id = 4,
            username = "Tatyana_Ullrich"
        ),
        UserDTO(
            img = "https://randomContact.me/api/portraits/men/5.jpg",
            name = "Ms. Simeon Yost",
            id = 5,
            username = "Yasmine_Von5"
        ),
        UserDTO(
            img = "https://randomContact.me/api/portraits/men/6.jpg",
            name = "Mr. Ewell Reynolds",
            id = 6,
            username = "Alysson50"
        )
    )

    fun mockedListUser() = listOf<User>(
        User(
            img = "https://randomContact.me/api/portraits/men/1.jpg",
            name = "Sandrine Spinka",
            id = 1,
            username = "Tod86"
        ),
        User(
            img = "https://randomContact.me/api/portraits/men/2.jpg",
            name = "Carli Carroll",
            id = 2,
            username = "Constantin_Sawayn"
        ),
        User(
            img = "https://randomContact.me/api/portraits/men/3.jpg",
            name = "Annabelle Reilly",
            id = 3,
            username = "Lawrence_Nader62"
        ),
        User(
            img = "https://randomContact.me/api/portraits/men/4.jpg",
            name = "Mrs. Hilton Welch",
            id = 4,
            username = "Tatyana_Ullrich"
        ),
        User(
            img = "https://randomContact.me/api/portraits/men/5.jpg",
            name = "Ms. Simeon Yost",
            id = 5,
            username = "Yasmine_Von5"
        ),
        User(
            img = "https://randomContact.me/api/portraits/men/6.jpg",
            name = "Mr. Ewell Reynolds",
            id = 6,
            username = "Alysson50"
        )
    )
}