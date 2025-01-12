package dev.materii.gloom.di.module

import dev.materii.gloom.ui.screen.auth.viewmodel.LandingViewModel
import dev.materii.gloom.ui.screen.explore.viewmodel.ExploreViewModel
import dev.materii.gloom.ui.screen.explorer.viewmodel.DirectoryListingViewModel
import dev.materii.gloom.ui.screen.explorer.viewmodel.FileViewerViewModel
import dev.materii.gloom.ui.screen.home.viewmodel.HomeViewModel
import dev.materii.gloom.ui.screen.list.viewmodel.OrgListViewModel
import dev.materii.gloom.ui.screen.list.viewmodel.RepositoryListViewModel
import dev.materii.gloom.ui.screen.list.viewmodel.SponsoringViewModel
import dev.materii.gloom.ui.screen.list.viewmodel.StarredReposListViewModel
import dev.materii.gloom.ui.screen.profile.viewmodel.FollowersViewModel
import dev.materii.gloom.ui.screen.profile.viewmodel.FollowingViewModel
import dev.materii.gloom.ui.screen.profile.viewmodel.ProfileViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.LicenseViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.RepoCodeViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.RepoDetailsViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.RepoIssuesViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.RepoPullRequestsViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.RepoReleasesViewModel
import dev.materii.gloom.ui.screen.repo.viewmodel.RepoViewModel
import dev.materii.gloom.ui.screen.settings.viewmodel.AccountSettingsViewModel
import dev.materii.gloom.ui.screen.settings.viewmodel.AppIconsSettingsViewModel
import dev.materii.gloom.ui.screen.settings.viewmodel.AppearanceSettingsViewModel
import dev.materii.gloom.ui.screen.settings.viewmodel.SettingsViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

fun viewModelModule() = module {

    factoryOf(::LandingViewModel)
    factoryOf(::ProfileViewModel)
    factoryOf(::RepositoryListViewModel)
    factoryOf(::StarredReposListViewModel)
    factoryOf(::OrgListViewModel)
    factoryOf(::FollowersViewModel)
    factoryOf(::FollowingViewModel)
    factoryOf(::SponsoringViewModel)
    factoryOf(::SettingsViewModel)
    factoryOf(::AppearanceSettingsViewModel)
    factoryOf(::AccountSettingsViewModel)
    factoryOf(::AppIconsSettingsViewModel)
    factoryOf(::HomeViewModel)
    factoryOf(::ExploreViewModel)

    factoryOf(::RepoViewModel)
    factoryOf(::RepoDetailsViewModel)
    factoryOf(::RepoCodeViewModel)
    factoryOf(::DirectoryListingViewModel)
    factoryOf(::FileViewerViewModel)
    factoryOf(::RepoIssuesViewModel)
    factoryOf(::RepoPullRequestsViewModel)
    factoryOf(::RepoReleasesViewModel)
    factoryOf(::LicenseViewModel)

}