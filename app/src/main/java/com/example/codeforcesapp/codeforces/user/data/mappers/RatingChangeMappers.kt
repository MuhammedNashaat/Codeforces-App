package com.example.codeforcesapp.codeforces.user.data.mappers

import com.example.codeforcesapp.codeforces.user.data.networking.dto.RatingChangeDto
import com.example.codeforcesapp.codeforces.user.domain.RatingChange

fun RatingChangeDto.toRatingChange():RatingChange{
    return RatingChange(
        contestId = this.contestId,
        contestName = this.contestName,
        handle = this.handle,
        rank = this.rank,
        ratingUpdateTimeSeconds = this.ratingUpdateTimeSeconds,
        oldRating = this.oldRating,
        newRating = this.newRating
    )
}