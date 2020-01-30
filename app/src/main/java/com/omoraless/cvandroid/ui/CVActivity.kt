package com.omoraless.cvandroid.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.omoraless.cvandroid.R
import com.omoraless.cvandroid.base.BaseActivity
import com.omoraless.cvandroid.databinding.ActivityCvBinding
import com.omoraless.cvandroid.extension.getImageByUrl
import com.omoraless.cvandroid.model.CV
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_cv.*


class CVActivity : BaseActivity<CVPresenter>(), CVView {
    /**
     * DataBinding instance
     */
    private lateinit var binding: ActivityCvBinding

    /**
     * The adapter for the list of career jobs
     */
    private val cvAdapter = CVAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cv)
        binding.adapter = cvAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun updateCV(cvdata: CV) {
        cvAdapter.updateCareerJobs(cvdata.career_history)
        cv_image.getImageByUrl(cvdata.contact_information.url_image)
        binding.information = cvdata
        binding.executePendingBindings()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): CVPresenter {
        return CVPresenter(this)
    }

}
