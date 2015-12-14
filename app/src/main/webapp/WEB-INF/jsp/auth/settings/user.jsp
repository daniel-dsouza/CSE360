<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:template>
  <jsp:attribute name="head">
    <link href="/css/auth/settings/user.css" rel="stylesheet" media="screen">
      <script type="text/javascript" src="/js/auth/settings/user.js"></script>
          </jsp:attribute>
    <jsp:body>

        <section id="page-keeper">
            <div class="container-fluid">
                <!-- http://bootsnipp.com/snippets/kE7Zd
                Brand and toggle get grouped for better mobile display -->

                <ul class="nav navbar-nav sider-navbar">
                    <li id="profile">
                        <figure class="profile-userpic">
                            <img src="/images/default-profile.jpg"
                                 class="img-responsive" alt="Profile Picture">
                        </figure>
                        <div class="profile-usertitle">
                            <div class="profile-usertitle-name"><c:out value="${user.person.firstName}"/> <c:out
                                    value="${user.person.lastName}"/></div>
                            <div class="profile-usertitle-title"><c:out value="${user.person.occupation}"/></div>
                        </div>
                    </li>
                    <li class="sider-menu">
                        <ul>
                            <li class="active" id="changePassword" onclick="redirectSettings(this)"><a href="#"><span
                                    class="fa fa-fw fa-dashboard"></span> Change password</a>
                            </li>
                            <li id="changeProfile"><a href="#"><span class="fa fa-fw fa-dashboard"></span> Change
                                Profile picture</a>
                            </li>
                            <c:if test="${user.person.occupation == 'hsp'}">

                                <li>
                                    <a href="#" data-toggle="collapse" data-target="#submenu-1"><span
                                            class="fa fa-database"></span> Database <span
                                            class="fa fa-fw fa-caret-down"></span></a>
                                    <ul id="submenu-1" class="collapse">
                                        <li><a href="#">MySQL</a></li>
                                        <li><a href="#">PostgreSQL</a></li>
                                        <li><a href="#">Oracle</a></li>
                                    </ul>
                                </li>
                                <li id="masterPanel" onclick="redirectSettings(this)"><a href="#"><span
                                        class="fa fa-folder"></span> Master Panel</a></li>
                                <li>
                                    <a href="#" data-toggle="collapse" data-target="#submenu-2"><i
                                            class="fa fa-cog"></i>
                                        System
                                        <span class="fa fa-fw fa-caret-down"></span></a>
                                    <ul id="submenu-2" class="collapse">
                                        <li><a href="#"><i class="fa fa-fw fa-bar-chart-o"></i> Statistics</a></li>
                                        <li><a href="#"><i class="fa fa-code"></i> API</a></li>
                                        <li><a href="#"><span class="fa fa-exclamation-circle"></span> Error Log</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:if>
                        </ul>
                    </li>
                </ul>


                <div class="row" style="margin-left: 15px">
                    <div class="col-md-12">
                        <h1>Content Section</h1>
                    </div>
                    <div class="col-md-5">
                        <h3>Left Header</h3>

                        <p>
                            Careful, if you break something, I will make a man out of you.
                            Get ready, cause I will make your life miserable. But sir, "Can't you see the tears we're
                            cryin'?
                            Can't there be some happiness for me?"
                            Hah! If you walk the footsteps of a stranger, you'll learn things you never knew.
                            Confused? It's clear from your vacant expressions, the lights are not all on upstairs.
                        </p>
                    </div>
                    <div class="col-md-7">
                        <h3>Right Header</h3>

                        <p>
                            Wait! Don't let this siren cast her spell. It's easier to Let it go!
                            Then we can all just see the lights, and it’s like the fog has lifted.
                            Do not be fooled by its commonplace appearance.
                        </p>

                        <p>
                            Why should I worry? IPIMS is great, forget about your worries and your strife.
                            Once you get treated, look inside yourself. You are more than what you have become.
                        </p>
                    </div>
                </div>
            </div>
        </section>
    </jsp:body>
</t:template>


