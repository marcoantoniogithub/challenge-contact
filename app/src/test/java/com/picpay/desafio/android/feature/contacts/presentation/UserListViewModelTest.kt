package com.picpay.desafio.android.feature.contacts.presentation

import com.picpay.desafio.android.core.BaseTest
import com.picpay.desafio.android.feature.contacts.domain.usecase.PicPayUseCase
import com.picpay.desafio.android.feature.contacts.mock.MockContactProvider.mockedListUser
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UserListViewModelTest: BaseTest() {

    private val useCase: PicPayUseCase = mockk()

    private lateinit var viewModel: UserListViewModel

    override fun setup() {
        super.setup()
        viewModel = UserListViewModel(useCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call use case when get users is called`() =
        runTest(StandardTestDispatcher()) {
            val mockResult = mockedListUser()

            coEvery { useCase.getUsers() } returns mockResult

            viewModel.getUsers()

            coVerify { useCase.getUsers() }
            assertEquals(mockResult, viewModel.listUser.value)
            assertEquals(null, viewModel.messageError.value)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `should throw an exception when get users is called`() =
        runTest(StandardTestDispatcher()) {
            val msgError = "falhou no teste"

            coEvery { useCase.getUsers() } throws Exception(msgError)

            viewModel.getUsers()

            coVerify { useCase.getUsers() }
            assertEquals(viewModel.messageError.value, msgError)
            assertEquals(viewModel.listUser.value, null)
        }

}