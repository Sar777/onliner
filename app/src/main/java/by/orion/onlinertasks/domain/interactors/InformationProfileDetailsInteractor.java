package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.common.triple.ImmutableTriple;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.data.models.requests.ProfileRequestParams;
import by.orion.onlinertasks.data.models.sections.Sections;
import by.orion.onlinertasks.data.repository.profile.ProfileDetailsRepository;
import by.orion.onlinertasks.data.repository.regions.RegionsRepository;
import by.orion.onlinertasks.data.repository.sections.SectionsRepository;
import by.orion.onlinertasks.presentation.profile.details.pages.mappers.ProfileToProfileDetailsInformationMapper;
import by.orion.onlinertasks.presentation.profile.details.pages.models.ProfileDetailsInformation;
import io.reactivex.Single;

public class InformationProfileDetailsInteractor {

    @NonNull
    private final ProfileDetailsRepository profileDetailsRepository;

    @NonNull
    private final RegionsRepository regionsRepository;

    @NonNull
    private final SectionsRepository sectionsRepository;

    @NonNull
    private final ProfileToProfileDetailsInformationMapper profileToProfileDetailsInformationMapper;

    @Inject
    public InformationProfileDetailsInteractor(@NonNull ProfileDetailsRepository profileDetailsRepository,
                                               @NonNull RegionsRepository regionsRepository,
                                               @NonNull SectionsRepository sectionsRepository,
                                               @NonNull ProfileToProfileDetailsInformationMapper profileToProfileDetailsInformationMapper) {
        this.profileDetailsRepository = profileDetailsRepository;
        this.regionsRepository = regionsRepository;
        this.sectionsRepository = sectionsRepository;
        this.profileToProfileDetailsInformationMapper = profileToProfileDetailsInformationMapper;
    }

    public Single<ProfileDetailsInformation> getProfileDetailsInformation(@NonNull ProfileRequestParams params) {
        Single<Profile> profile = profileDetailsRepository.getProfile(params);
        Single<List<Region>> regions = regionsRepository.getRegions();
        Single<Sections> sections = sectionsRepository.getSectionsWithCategories();

        return Single.zip(profile, regions, sections, ImmutableTriple::new)
                .map(profileToProfileDetailsInformationMapper::map);
    }
}
