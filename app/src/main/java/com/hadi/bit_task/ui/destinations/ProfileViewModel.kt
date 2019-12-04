package com.hadi.bit_task.ui.destinations

import androidx.lifecycle.ViewModel
import com.hadi.bit_task.repo.ProfileRepo

class ProfileViewModel : ViewModel() {
    private val profileRepo = ProfileRepo.mInstance

    val profileData = profileRepo.fetchProfile()
    val profileMedia = profileRepo.fetchProfileMedia()
}
