import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TopNavigationBarComponent } from './top-navigation-bar/top-navigation-bar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  declarations: [TopNavigationBarComponent],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule
  ],
  exports: [
    TopNavigationBarComponent
  ]
})
export class TopNavigationModule { }
