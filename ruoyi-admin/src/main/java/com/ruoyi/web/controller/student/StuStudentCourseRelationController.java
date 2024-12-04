package com.ruoyi.web.controller.student;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.StuStudentCourseRelation;
import com.ruoyi.system.service.IStuStudentCourseRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选修（student_course_relation）课Controller
 * 
 * @author SZF
 * @date 2024-12-04
 */
@RestController
@RequestMapping("/system/student_course_relation")
public class StuStudentCourseRelationController extends BaseController
{
    @Autowired
    private IStuStudentCourseRelationService stuStudentCourseRelationService;

    /**
     * 查询选修（student_course_relation）课列表
     */
    @PreAuthorize("@ss.hasPermi('system:student_course_relation:list')")
    @GetMapping("/list")
    public TableDataInfo list(StuStudentCourseRelation stuStudentCourseRelation)
    {
        startPage();
        List<StuStudentCourseRelation> list = stuStudentCourseRelationService.selectStuStudentCourseRelationList(stuStudentCourseRelation);
        return getDataTable(list);
    }

    /**
     * 导出选修（student_course_relation）课列表
     */
    @PreAuthorize("@ss.hasPermi('system:student_course_relation:export')")
    @Log(title = "选修（student_course_relation）课", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StuStudentCourseRelation stuStudentCourseRelation)
    {
        List<StuStudentCourseRelation> list = stuStudentCourseRelationService.selectStuStudentCourseRelationList(stuStudentCourseRelation);
        ExcelUtil<StuStudentCourseRelation> util = new ExcelUtil<StuStudentCourseRelation>(StuStudentCourseRelation.class);
        util.exportExcel(response, list, "选修（student_course_relation）课数据");
    }

    /**
     * 获取选修（student_course_relation）课详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:student_course_relation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(stuStudentCourseRelationService.selectStuStudentCourseRelationById(id));
    }

    /**
     * 新增选修（student_course_relation）课
     */
    @PreAuthorize("@ss.hasPermi('system:student_course_relation:add')")
    @Log(title = "选修（student_course_relation）课", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StuStudentCourseRelation stuStudentCourseRelation)
    {
        return toAjax(stuStudentCourseRelationService.insertStuStudentCourseRelation(stuStudentCourseRelation));
    }

    /**
     * 修改选修（student_course_relation）课
     */
    @PreAuthorize("@ss.hasPermi('system:student_course_relation:edit')")
    @Log(title = "选修（student_course_relation）课", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StuStudentCourseRelation stuStudentCourseRelation)
    {
        return toAjax(stuStudentCourseRelationService.updateStuStudentCourseRelation(stuStudentCourseRelation));
    }

    /**
     * 删除选修（student_course_relation）课
     */
    @PreAuthorize("@ss.hasPermi('system:student_course_relation:remove')")
    @Log(title = "选修（student_course_relation）课", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stuStudentCourseRelationService.deleteStuStudentCourseRelationByIds(ids));
    }
}
