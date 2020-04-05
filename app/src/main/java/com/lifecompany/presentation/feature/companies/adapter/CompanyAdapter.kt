package com.lifecompany.presentation.feature.companies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lifecompany.BuildConfig
import com.lifecompany.R
import com.lifecompany.domain.model.Company
import kotlinx.android.synthetic.main.company_item.view.*

class CompanyAdapter(
    private val clickListener: (Company) -> Unit
): RecyclerView.Adapter<CompanyAdapter.CompanyHolder>() {

    private val companies: MutableList<Company> = mutableListOf()

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): CompanyHolder {
        val inflater = LayoutInflater.from(container.context)
        val holder = CompanyHolder(inflater.inflate(R.layout.company_item, container,false))
        holder.itemView.setOnClickListener { clickListener(companies[holder.adapterPosition]) }
        return holder
    }

    override fun getItemCount(): Int = companies.size

    override fun onBindViewHolder(holder: CompanyHolder, position: Int) {
        holder.bind(companies[position])
    }

    fun setData(list: List<Company>) {
        companies.clear()
        companies.addAll(list)
        notifyDataSetChanged()
    }

    class CompanyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(company: Company) {
            Glide.with(itemView)
                .load("${BuildConfig.API_SERVER}${company.img}")
                .into(itemView.companyImg)

            itemView.companyName.text = company.name
        }
    }
}