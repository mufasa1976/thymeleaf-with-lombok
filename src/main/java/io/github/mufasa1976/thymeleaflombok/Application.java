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

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Controller
@Slf4j
public class Application {

  private static final String INDEX_URL = "/index.html";
  private static final String INDEX_TEMPLATE = "index";
  private static final String ARGUMENT_GREETING = "greeting";

  public static void main(String... args) {
    new SpringApplicationBuilder(Application.class)
        .run(args);
  }

  @GetMapping("/")
  public String root() {
    return "redirect:" + INDEX_URL;
  }

  @GetMapping(INDEX_URL)
  public ModelAndView index() {
    ModelAndView view = new ModelAndView(INDEX_TEMPLATE);
    log.info("Initialize with anonymous Information");
    view.addObject(ARGUMENT_GREETING,
        Greeting.builder()
            .name("anonymous")
            .age(0)
            .build());
    return view;
  }

  @PostMapping(INDEX_URL)
  public ModelAndView greeting(@Valid Greeting greeting) {
    ModelAndView view = new ModelAndView(INDEX_TEMPLATE);
    log.info("Greeting Information: {}", greeting);
    view.addObject(ARGUMENT_GREETING, greeting);
    return view;
  }

}
