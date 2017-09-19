package by.orion.onlinertasks.presentation.main.fragments.tasks.mappers;

import android.support.annotation.NonNull;

import by.orion.onlinertasks.common.GenericObjectMapper;
import by.orion.onlinertasks.data.models.task.Section;
import by.orion.onlinertasks.presentation.main.fragments.tasks.models.SectionItem;

public class TaskSectionToTaskSectionItemMapper implements GenericObjectMapper<Section, SectionItem> {
    
    @NonNull
    @Override
    public SectionItem map(@NonNull Section section) {
        return SectionItem.builder()
                .id(section.id())
                .name(section.name())
                .slug(section.slug())
                .build();
    }
}
