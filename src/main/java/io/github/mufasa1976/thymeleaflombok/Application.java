/*
   Copyright (C) 2016 by the original Authors.

   This program is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program; if not, write to the Free Software Foundation,
   Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
*/
package io.github.mufasa1976.thymeleaflombok;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class Application {

  public static void main(String... args) {
    new SpringApplicationBuilder(Application.class)
        .run(args);
  }

  @GetMapping("/index.html")
  public ModelAndView index() {
    ModelAndView view = new ModelAndView("index");
    view.addObject("greeting",
        Greeting.builder()
            .name("anonymous")
            .age(0)
            .build());
    return view;
  }

  @PostMapping("/index.html")
  public ModelAndView greeting(@Valid Greeting greeting) {
    ModelAndView view = new ModelAndView("index");
    view.addObject("greeting", greeting);
    return view;
  }

}
