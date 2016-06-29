package net.muxi.huashiapp.common.net;

import net.muxi.huashiapp.common.data.BookSearchResult;
import net.muxi.huashiapp.common.data.Course;
import net.muxi.huashiapp.common.data.PersonalBook;
import net.muxi.huashiapp.common.data.Scores;
import net.muxi.huashiapp.common.data.VerifyResponse;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ybao on 16/4/28.
 */
public interface RetrofitService {

    @GET("info/login/")
    Observable<Response<VerifyResponse>> mainLogin(@Header("Authorization") String authorization);

    @GET("lib/login")
    Observable<Response<VerifyResponse>> libLogin(@Header("Authorization") String verification);

    @GET("lib/search/")
    Observable<BookSearchResult> searchBook(@Query("keyword")String keyword,
                                            @Query("page") String page);

    @GET("lib/me/")
    Observable<PersonalBook> getPersonalBook(@Header("Authorizaiton") String verification);

    //URL: /api/table/?xnm='2015'&xqm='3'&sid='2016210761'
    @GET("table/")
    Observable<List<Course>> getSchedule(@Header("Authorization") String verification,
                                         @Query("xnm") String year,
                                         @Query("xqm") String term,
                                         @Query("sid") String sid);

    //添加课程
    @POST("table/")
    Observable<Response> addCourse(@Header("Authorization") String authorization,
                                   @Body Course course);

    //删除课程
    @DELETE("table/{id}/")
    Observable<Response> deleteCourse(@Header("Authorization") String authorization,
                                      @Path("id") String id);

    //URL: /api/grade/search/?sid=2014210761&xnm=2015&xqm=3
    @GET("grade/search/")
    Observable<List<Scores>> getScores(@Header("Authorization") String verification,
                                 @Query("xnm") String year,
                                 @Query("xqm") String term,
                                 @Query("sid") String sid);

}
