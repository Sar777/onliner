package by.orion.onlinertasks.domain.interactors;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;

import java.util.List;

import javax.inject.Inject;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.data.models.profile.details.Profile;
import by.orion.onlinertasks.data.models.regions.Region;
import by.orion.onlinertasks.data.models.requests.ProfileRequestParams;
import by.orion.onlinertasks.data.repository.profile.ProfileDetailsRepository;
import by.orion.onlinertasks.data.repository.regions.RegionsRepository;
import by.orion.onlinertasks.presentation.profile.details.pages.mappers.ProfileToProfileDetailsInformationMapper;
import by.orion.onlinertasks.presentation.profile.details.pages.models.ProfileDetailsInformation;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;

public class InformationProfileDetailsInteractor {

    @NonNull
    private final ProfileDetailsRepository profileDetailsRepository;

    @NonNull
    private final RegionsRepository regionsRepository;

    @NonNull
    private final ProfileToProfileDetailsInformationMapper profileToProfileDetailsInformationMapper;

    @Inject
    public InformationProfileDetailsInteractor(@NonNull ProfileDetailsRepository profileDetailsRepository, @NonNull RegionsRepository regionsRepository, @NonNull ProfileToProfileDetailsInformationMapper profileToProfileDetailsInformationMapper) {
        this.profileDetailsRepository = profileDetailsRepository;
        this.regionsRepository = regionsRepository;
        this.profileToProfileDetailsInformationMapper = profileToProfileDetailsInformationMapper;
    }

    public Single<ProfileDetailsInformation> getProfileDetailsInformation(@NonNull ProfileRequestParams params) {
//        return Observable.zip(profileDetailsRepository.getProfile(params), regionsRepository.getRegions(), new BiFunction<Profile, List<Region>, Pair<Profile, List<Region>>>() {
//            @Override
//            public Pair<Profile, List<Region>> apply(Profile profile, List<Region> regions) throws Exception {
//                return new Pair<>(profile, regions);
//            }})
//            .map()
//                .map(profileToProfileDetailsInformationMapper::map);
    }
}
