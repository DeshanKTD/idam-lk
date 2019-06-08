import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TopNavigationModule } from './top-navigation/top-navigation.module';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TopNavigationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
