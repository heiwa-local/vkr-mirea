package com.heiwalocal.data.mappers

import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.data.services.local.dto.UserPojo
import com.heiwalocal.domain.entities.LocalUser

class UserMapper: BaseMapper<UserPojo, LocalUser> {
    override fun transform(type: UserPojo): LocalUser {
        return LocalUser(
            id = type.id,
            currentUser = type.currentUser,
            accessToken = type.accessToken
        )
    }

    override fun transformToRepository(type: LocalUser): UserPojo {
        TODO("Not yet implemented")
    }
}