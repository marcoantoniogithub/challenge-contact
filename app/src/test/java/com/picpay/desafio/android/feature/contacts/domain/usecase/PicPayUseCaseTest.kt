package com.picpay.desafio.android.feature.contacts.domain.usecase

import com.picpay.desafio.android.core.BaseTest
import com.picpay.desafio.android.feature.contacts.domain.repository.PicPayRepository
import com.picpay.desafio.android.feature.contacts.mock.MockContactProvider.mockedListUser
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class PicPayUseCaseTest : BaseTest(){

    private val picPayRepository: PicPayRepository = mockk()
    private lateinit var useCase: PicPayUseCase

    override fun setup() {
        super.setup()
        useCase = PicPayUseCase(picPayRepository)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call repository when get users is called`() =
        runTest {
            val mockResult = mockedListUser()

            coEvery { picPayRepository.getUsers() } returns mockResult

            val result = useCase.getUsers()

            assertEquals(mockResult, result)
        }
}