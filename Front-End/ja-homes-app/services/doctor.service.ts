import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Doctor} from "../src/app/doctor";

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private baseUrl = 'http://DEV-1261.mshome.net:8080/Project/webapi/Doctors';
  private headers= {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) {

  }


  getAllDoctors(): Observable<any[]>{ //[] if the return is array
    // @ts-ignore
    return this
        .http
        .get<any[]>(this.baseUrl)
  }

  getDoctorsBySearch(filter: any): Observable<any[]> {
    const url = `${this.baseUrl}/Search`; 
    return this.http.get<any[]>(url, { params: filter });  }


  insertDoctor(doctor: Doctor): Observable<Doctor> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

   return this.http.post<Doctor>(`${this.baseUrl}`, doctor, { headers });
}

}
