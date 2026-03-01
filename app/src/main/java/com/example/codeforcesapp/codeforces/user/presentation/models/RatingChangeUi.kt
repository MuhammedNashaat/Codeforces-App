package com.example.codeforcesapp.codeforces.user.presentation.models

import com.example.codeforcesapp.codeforces.user.domain.RatingChange

data class RatingChangeUi(
    val contestId: Int,
    val contestName: String,
    val handle: String,
    val rank: Int,
    val ratingUpdateTimeSeconds: Int, //need to be changed later
    val oldRating: Int,
    val newRating: Int
)

fun RatingChange.toRatingChangeUi():RatingChangeUi{
    return RatingChangeUi(
        contestId = this.contestId,
        contestName = this.contestName,
        handle = this.handle,
        rank = this.rank,
        ratingUpdateTimeSeconds = this.ratingUpdateTimeSeconds, //need to be change later
        oldRating = this.oldRating,
        newRating = this.newRating
    )
}