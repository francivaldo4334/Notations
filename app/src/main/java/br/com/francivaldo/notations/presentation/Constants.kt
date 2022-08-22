package br.com.francivaldo.notations.presentation

import br.com.francivaldo.notations.presentation.viewmodel.MainViewModel

object Constants {
    private var mViewModel:MainViewModel? = null
    fun setViewModel(mViewModel:MainViewModel){
        this.mViewModel = mViewModel
    }
    fun getViewModel():MainViewModel{
        return mViewModel!!
    }
}