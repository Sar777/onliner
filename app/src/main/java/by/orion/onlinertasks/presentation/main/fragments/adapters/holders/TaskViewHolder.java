package by.orion.onlinertasks.presentation.main.fragments.adapters.holders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import by.orion.onlinertasks.R;
import by.orion.onlinertasks.common.adapters.holders.AbstractViewHolder;
import by.orion.onlinertasks.data.models.task.Author;
import by.orion.onlinertasks.data.models.task.Price;
import by.orion.onlinertasks.data.models.task.Task;

public class TaskViewHolder extends AbstractViewHolder<Task> {

    @BindView(R.id.imageview_task_preview)
    ImageView imageViewPreview;

    @BindView(R.id.textview_task_title)
    TextView textViewTitle;

    @BindView(R.id.textview_task_description)
    TextView textViewDescription;

    @BindView(R.id.textivew_task_price)
    TextView textViewPrice;

    @BindView(R.id.textivew_task_status)
    TextView textViewStatus;

    @BindView(R.id.textview_task_deadline)
    TextView textViewDeadline;

    @BindView(R.id.textview_task_location)
    TextView textViewLocation;

    @BindView(R.id.textview_task_proposal)
    TextView textViewProposal;

    @BindView(R.id.textview_task_section)
    TextView textViewSection;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onBindHolder(@NonNull Task task) {
        Context context = itemView.getContext();

        Author author = task.author();

        if (!TextUtils.isEmpty(author.photo())) {
            Glide.with(context)
                    .load(author.photo())
                    .apply(new RequestOptions().transform(new CircleCrop()))
                    .into(imageViewPreview);
        }

        textViewTitle.setText(task.title());
        textViewDescription.setText(task.description());
        textViewStatus.setText(task.status());
        textViewDeadline.setText(task.deadline());
        textViewLocation.setText(task.location().town());

        Price price = task.price();
        if (price != null) {
            textViewPrice.setText(String.valueOf(price.amount()));
        }

        if (task.proposals_qty() > 0) {
            textViewProposal.setVisibility(View.VISIBLE);
            textViewProposal.setText(String.valueOf(task.proposals_qty()));
        } else {
            textViewProposal.setVisibility(View.GONE);
        }

        textViewSection.setText(task.section().name());
    }
}
