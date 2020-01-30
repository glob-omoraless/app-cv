package com.omoraless.cvandroid.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.omoraless.cvandroid.R
import com.omoraless.cvandroid.databinding.ItemCareerJobBinding
import com.omoraless.cvandroid.model.CareerHistory

/**
 * Adapter for the list of the careerjobs
 * @property context Context in which the application is running
 */
class CVAdapter(private val context: Context) : RecyclerView.Adapter<CVAdapter.CVViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ItemCareerJobBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_career_job, parent, false)
        return CVViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return careerjob.size
    }

    override fun onBindViewHolder(holder: CVViewHolder, position: Int) {
        holder.bind(careerjob[position])
    }

    /**
     * The list of carreerjobs of the adapter
     */
    private var careerjob: List<CareerHistory> = listOf()

    /**
     * Updates the list of carreerjobs of the adapter
     * @param carreerjobs the new list of carreerjobs of the adapter
     */
    fun updateCareerJobs(jobs: List<CareerHistory>) {
        this.careerjob = jobs
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for CareerJob item
     */
    inner class CVViewHolder(private val binding: ItemCareerJobBinding) : RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds a careerjob into the view
         */
        fun bind(cv: CareerHistory) {
            binding.cv = cv
            binding.executePendingBindings()
        }
    }
}