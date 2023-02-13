package com.picpay.desafio.android.feature.contacts.data

import com.picpay.desafio.android.core.BaseTest
import com.picpay.desafio.android.feature.contacts.data.local.PicPayDataSourceLocal
import com.picpay.desafio.android.feature.contacts.data.remote.PicPayDataSourceRemote
import com.picpay.desafio.android.feature.contacts.domain.model.User
import com.picpay.desafio.android.feature.contacts.domain.repository.PicPayRepository
import com.picpay.desafio.android.feature.contacts.mock.MockContactProvider.mockedListUser
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

class PicPayRepositoryTest: BaseTest() {

    private val local: PicPayDataSourceLocal = mockk()
    private val remote: PicPayDataSourceRemote = mockk()

    private lateinit var repository: PicPayRepository

    override fun setup() {
        super.setup()
        repository = PicPayRepositoryImpl(remote = remote, local = local)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call getUsers when have users in local return local`() =
        runTest(StandardTestDispatcher()) {
            val mockResultRemote = emptyList<User>()
            val mockResultLocal = mockedListUser()
            val mockResult = mockedListUser()

            coEvery { remote.getUsers() } returns mockResultRemote
            coEvery { local.getUsers() } returns mockResultLocal

            val result = repository.getUsers()

            coVerify(exactly = 0) { remote.getUsers() }

            assertEquals(mockResult, result)
        }

    @ExperimentalCoroutinesApi
    @Test
    fun `should call getUsers when don´t have users in local called remote`() =
        runTest(StandardTestDispatcher()) {
            val mockResultRemote = mockedListUser()
            val mockResultLocal = emptyList<User>()
            val mockResult = mockedListUser()

            coEvery { remote.getUsers() } returns mockResultRemote
            coEvery { local.getUsers() } returns mockResultLocal
            coEvery { local.deleteAll() } returns Unit
            coEvery { local.insertAll(mockedListUser()) } returns Unit

            val result = repository.getUsers()

            coVerify(exactly = 1) { local.getUsers() }
            coVerify(exactly = 1) { local.deleteAll() }
            coVerify(exactly = 1) { local.insertAll(mockResultRemote) }
            coVerify(exactly = 1) { remote.getUsers() }

            assertEquals(mockResult, result)
        }

    @ExperimentalCoroutinesApi
    @Test(expected = Exception::class)
    fun `should throw an exception when get users is called`() =
        runTest(StandardTestDispatcher()) {

            coEvery{ repository.getUsers() } throws Exception()

            repository.getUsers()
        }
}