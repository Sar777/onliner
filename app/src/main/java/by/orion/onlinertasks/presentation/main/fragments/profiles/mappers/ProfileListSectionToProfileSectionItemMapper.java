package by.orion.onlinertasks.presentation.main.fragments.profiles.mappers;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.GenericObjectMapper;

public class ProfileListSectionToProfileSectionItemMapper implements GenericObjectMapper<List<String>, String> {

    private static final int MAX_VISIBLE_SECTIONS = 2;

    @NonNull
    private final Context context;

    public ProfileListSectionToProfileSectionItemMapper(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public String map(@NonNull List<String> sections) {
        StringBuilder builder = new StringBuilder();
        builder.append(sections.get(0)).append(", ");

        for (int i = 1; i < sections.size() && i < MAX_VISIBLE_SECTIONS; ++i) {
            builder.append(sections.get(i).toLowerCase())
                    .append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());

        if (sections.size() > 2) {
            builder.append(" + ")
                    .append(sections.size() - 2)
                    .append(" ")
                    .append(context.getString(R.string.msg_profile_section));
        }
        return builder.toString();
    }
}
