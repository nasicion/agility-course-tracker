import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';
import { CourseComponent } from './course.component';
import { RunsComponent } from './runs.component';
import {CourseResolver} from "./course.resolver";
import {CourseService} from "./service/course.service";

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'course', component: CourseComponent },
  { path: 'course/:courseId', component: CourseComponent, resolve:{course: CourseResolver} },
  { path: '',   redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CourseComponent,
    RunsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CourseService,CourseResolver],
  bootstrap: [AppComponent]
})
export class AppModule { }
