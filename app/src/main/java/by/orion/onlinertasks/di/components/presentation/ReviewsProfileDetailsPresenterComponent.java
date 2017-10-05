
package by.orion.onlinertasks.di.components.presentation;

import by.orion.onlinertasks.di.components.ApplicationComponent;
import by.orion.onlinertasks.di.modules.presentation.ReviewsProfileDetailsPresenterModule;
import by.orion.onlinertasks.di.scopes.Presenter;
import by.orion.onlinertasks.presentation.profile.details.pages.reviews.ReviewsProfileDetailsPresenter;
import dagger.Component;

@Presenter
@Component(dependencies = ApplicationComponent.class, modules = ReviewsProfileDetailsPresenterModule.class)
public interface ReviewsProfileDetailsPresenterComponent {

    ReviewsProfileDetailsPresenter getPresenter();
}